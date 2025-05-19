package mimex;

import mindustry.Vars;

public class StatusEffectsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("hidden")
                .append(newLine);

        Vars.content.statusEffects().each(item -> sbr.append(item.name)
                .append(';').append(item.id)
                .append(';').append(LogicIdConvertor.lookupLogicId(item))
                .append(';').append(item.isHidden())
                .append(newLine));

        writeToFile("status-effects");
    }
}
