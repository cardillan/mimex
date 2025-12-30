package mimex;

import arc.Core;
import arc.func.Prov;
import mindustry.gen.LogicIO;
import mindustry.logic.LStatement;

public class LogicStatementExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("opcode")
                .append(';').append("arguments")
                .append(';').append("name")
                .append(';').append("typeName")
                .append(';').append("hidden")
                .append(';').append("privileged")
                .append(';').append("nonPrivileged")
                .append(';').append("hint")
                .append(';').append("categoryName")
                .append(';').append("categoryColor")
                .append(';').append("categoryDescription")
                .append(newLine);

        for (Prov<LStatement> provider : LogicIO.allStatements) {
            LStatement statement = provider.get();

            createNameAndArguments(statement)
                    .append(';').append(statement.name())
                    .append(';').append(statement.typeName())
                    .append(';').append(statement.hidden())
                    .append(';').append(statement.privileged())
                    .append(';').append(statement.nonPrivileged())
                    .append(';').append(statementHint(statement))
                    .append(';').append(statement.category().name)
                    .append(';').append(statement.category().color)
                    .append(';').append(encode(statement.category().description()))
                    .append(newLine);
        }

        writeToFile("logic-statements");
    }

    private StringBuilder createNameAndArguments(LStatement statement) {
        int position = sbr.length();
        statement.write(sbr);

        for (int i = position; i < sbr.length(); i++) {
            if (sbr.charAt(i) == ' ') {
                sbr.setCharAt(i, ';');
                return sbr;
            }
        }

        return sbr.append(';');
    }

    private String statementHint(LStatement statement) {
        String key = "lst." + statement.name().replaceAll(" ", "").toLowerCase();
        return Core.bundle.has(key) ? encode(Core.bundle.get(key)) : "";
    }

    private static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            switch (c) {
                case '\n': sb.append("%0A"); break;
                case ';': sb.append("%3B"); break;
                case '%': sb.append("%25"); break;
                case '+': sb.append("%2B"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }
}
