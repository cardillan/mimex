package mimex;

import mindustry.Vars;

public class ItemsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(newLine);

        Vars.content.items().each(item -> sbr.append(item.name)
                .append(';').append(item.id)
                .append(';').append(-1)
                .append(newLine));

        writeToFile("items");
    }
}
