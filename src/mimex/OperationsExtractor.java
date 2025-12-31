package mimex;

import mindustry.logic.LogicOp;

public class OperationsExtractor extends ClassMetadataExtractor {

    public OperationsExtractor() {
        super(LogicOp.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("op")
                .append(';').append("symbol")
                .append(newLine);

        for (LogicOp operation : LogicOp.all) {
            sbr.append(operation.name())
                    .append(';').append(true)
                    .append(';').append(operation.symbol)
                    .append(newLine);
        }

        writeToFile("operations");
    }
}
