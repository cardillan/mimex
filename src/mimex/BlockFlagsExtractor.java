package mimex;

import mindustry.world.meta.BlockFlag;

import java.util.Arrays;
import java.util.HashSet;

public class BlockFlagsExtractor extends ClassMetadataExtractor {

    public BlockFlagsExtractor() {
        super(BlockFlag.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("ulocate")
                .append(newLine);

        HashSet<BlockFlag> logic = new HashSet<>(Arrays.asList(BlockFlag.allLogic));

        for (BlockFlag flag : BlockFlag.all) {
            sbr.append(flag.name())
                    .append(';').append(logic.contains(flag))
                    .append(newLine);
        }

        writeToFile("block-flags");
    }
}
