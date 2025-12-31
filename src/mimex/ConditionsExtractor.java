package mimex;

import mindustry.logic.ConditionOp;

public class ConditionsExtractor extends ClassMetadataExtractor {

    public ConditionsExtractor() {
        super(ConditionOp.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("jump")
                .append(';').append("select")
                .append(';').append("symbol")
                .append(newLine);

        for (ConditionOp condition : ConditionOp.all) {
            sbr.append(condition.name())
                    .append(';').append(true)
                    .append(';').append(true)
                    .append(';').append(condition.symbol)
                    .append(newLine);
        }

        writeToFile("conditions");
    }
}
