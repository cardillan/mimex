package mimex;

import mindustry.Vars;
import mindustry.type.Liquid;

public class LiquidsExtractor extends ClassMetadataExtractor {

    public LiquidsExtractor() {
        super(Liquid.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("color")
                .append(newLine);

        Vars.content.liquids().each(liquid -> sbr.append(liquid.name)
                .append(';').append(liquid.id)
                .append(';').append(-1)
                .append(';').append(liquid.color)
                .append(newLine));

        writeToFile("liquids");
    }
}
