package mimex;

import mindustry.logic.ConditionOp;

public class ConditionsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("symbol")
                .append(newLine);

        for (ConditionOp condition : ConditionOp.all) {
            sbr.append(condition.name())
                    .append(';').append(condition.symbol)
                    .append(newLine);
        }

        writeToFile("conditions");
    }
}
