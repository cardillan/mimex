package mimex;

import mindustry.logic.LogicRule;

public class LogicRuleExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (LogicRule rule : LogicRule.all) {
            sbr.append(rule.name())
                    .append(newLine);
        }

        writeToFile("logic-rules");
    }
}
