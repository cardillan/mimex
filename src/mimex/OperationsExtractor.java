package mimex;

import mindustry.logic.LogicOp;

public class OperationsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("symbol")
                .append(newLine);

        for (LogicOp operation : LogicOp.all) {
            sbr.append(operation.name())
                    .append(';').append(operation.symbol)
                    .append(newLine);
        }

        writeToFile("operations");
    }
}
