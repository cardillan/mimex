package mimex;

import arc.Core;

import java.util.Scanner;

public class IconsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        try (Scanner scan = new Scanner(Core.files.internal("icons/icons.properties").read(512))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] s = line.split("[|=]");
                if (s.length < 3) continue;
                String name = s[2].toUpperCase().replaceAll("-UI$", "");
                sbr.append(name).append(';').append(s[1]).append(';').append(s[0]).append(newLine);
            }
        }

        writeToFile("icons");
    }
}
