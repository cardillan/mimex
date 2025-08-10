package mimex;

import mindustry.Vars;

public class LiquidsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("color")
                .append(newLine);

        Vars.content.liquids().each(liquid -> sbr.append(liquid.name)
                .append(';').append(liquid.id)
                .append(';').append(LogicIdConvertor.lookupLogicId(liquid))
                .append(';').append(liquid.color)
                .append(newLine));

        writeToFile("liquids");
    }
}
