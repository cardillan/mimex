package mimex;

import mindustry.logic.LogicFx;

public class EffectsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("size")
                .append(';').append("rotate")
                .append(';').append("color")
                .append(';').append("data")
                .append(newLine);

        for (LogicFx.EffectEntry effect : LogicFx.entries()) {
            sbr.append(effect.name)
                    .append(';').append(effect.size)
                    .append(';').append(effect.rotate)
                    .append(';').append(effect.color)
                    .append(';').append(effect.data != null)
                    .append(newLine);
        }

        writeToFile("effects");
    }
}
