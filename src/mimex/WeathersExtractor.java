package mimex;

import mindustry.Vars;

public class WeathersExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(newLine);

        Vars.content.weathers().each(item -> sbr.append(item.name)
                .append(';').append(item.id)
                .append(';').append(LogicIdConvertor.lookupLogicId(item))
                .append(newLine));

        writeToFile("weathers");
    }
}
