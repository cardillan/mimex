package mimex;

import mindustry.world.blocks.logic.LogicDisplay;

public class GraphicsTypesExtractor extends ClassMetadataExtractor {

    public GraphicsTypesExtractor() {
        super(LogicDisplay.GraphicsType.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("draw")
                .append(newLine);

        for (LogicDisplay.GraphicsType type : LogicDisplay.GraphicsType.all) {
            sbr.append(type.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("graphics-types");
    }
}
