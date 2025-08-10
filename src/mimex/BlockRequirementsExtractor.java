package mimex;

import mindustry.Vars;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.Block;

public class BlockRequirementsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId");
        Vars.content.items().each(item -> sbr.append(";").append(item.name));
        sbr.append(newLine);

        Vars.content.blocks().each(block -> {
            sbr.append(block.name)
                    .append(';').append(block.id)
                    .append(';').append(LogicIdConvertor.lookupLogicId(block));

            Vars.content.items().each(item -> sbr.append(";").append(amount(block, item)));

            sbr.append(newLine);
        });

        writeToFile("block-requirements");
    }

    private int amount(Block block, Item item) {
        for (ItemStack r : block.requirements) {
            if (r.item == item) {
                return r.amount;
            }
        }
        return 0;
    }
}
