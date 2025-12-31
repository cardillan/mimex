package mimex;

import mindustry.logic.LogicRule;

public class LogicRuleExtractor extends ClassMetadataExtractor {

    public LogicRuleExtractor() {
        super(LogicRule.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("setrule")
                .append(newLine);

        for (LogicRule rule : LogicRule.all) {
            sbr.append(rule.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("logic-rules");
    }
}
