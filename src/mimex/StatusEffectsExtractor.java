package mimex;

import mindustry.Vars;
import mindustry.type.StatusEffect;

public class StatusEffectsExtractor extends ClassMetadataExtractor {

    public StatusEffectsExtractor() {
        super(StatusEffect.class);
    }

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
