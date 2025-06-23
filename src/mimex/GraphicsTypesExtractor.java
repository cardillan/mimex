package mimex;

import mindustry.world.blocks.logic.LogicDisplay;

public class GraphicsTypesExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (LogicDisplay.GraphicsType type : LogicDisplay.GraphicsType.all) {
            sbr.append(type.name())
                    .append(newLine);
        }

        writeToFile("graphics-types");
    }
}
