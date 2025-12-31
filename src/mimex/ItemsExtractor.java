package mimex;

import mindustry.Vars;
import mindustry.type.Item;

public class ItemsExtractor extends ClassMetadataExtractor {

    public ItemsExtractor() {
        super(Item.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("color")
                .append(newLine);

        Vars.content.items().each(item -> sbr.append(item.name)
                .append(';').append(item.id)
                .append(';').append(-1)
                .append(';').append(item.color)
                .append(newLine));

        writeToFile("items");
    }
}
