package cardillan.utils;

import java.util.HashMap;
import java.util.Map;

public class HashZero {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    // Multiplicative inverse of 31 modulo 2^32.
    private static final int INV31 = 0xBDEF7BDF;

    public static String makeHashZero(String original) {
        Map<Integer, String> prefixes = new HashMap<>();

        // Enumerate all 4-character prefixes.
        buildPrefixes(original.hashCode(), 4, new StringBuilder(), prefixes);

        // Work backward from the desired final hash: 0.
        char[] suffix = new char[4];
        String result = findSuffix(0, 4, suffix, prefixes);

        if (result == null) {
            throw new IllegalStateException("No 8-character suffix found");
        }

        return original + result;
    }

    private static void buildPrefixes(int hash, int remaining, StringBuilder prefix, Map<Integer, String> result) {
        if (remaining == 0) {
            result.putIfAbsent(hash, prefix.toString());
            return;
        }

        for (char c : ALPHABET) {
            prefix.append(c);
            buildPrefixes(hash * 31 + c, remaining - 1, prefix, result);
            prefix.setLength(prefix.length() - 1);
        }
    }

    private static String findSuffix(int hash, int remaining, char[] suffix, Map<Integer, String> prefixes) {
        if (remaining == 0) {
            String prefix = prefixes.get(hash);
            return prefix == null ? null : prefix + new String(suffix);
        }

        for (char c : ALPHABET) {
            // Reverse one step of Java's hash calculation:
            //
            // previous * 31 + c == hash (mod 2^32)
            int previous = (hash - c) * INV31;

            // We are working backward, from the last character.
            int index = remaining - 1;
            suffix[index] = c;

            String result = findSuffix(previous, remaining - 1, suffix, prefixes);

            if (result != null) return result;
        }

        return null;
    }

    public static void main(String[] args) {
        String original = "mindustry-metadata-extractor-000-";
        String modified = makeHashZero(original);

        System.out.println(modified);
        System.out.println(modified.hashCode()); // 0
    }
}
