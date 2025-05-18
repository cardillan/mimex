package mimex;

import mindustry.game.MapObjectives;

public class MarkersExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);


        for (String name : MapObjectives.allMarkerTypeNames) {
            sbr.append(name)
                    .append(newLine);
        }

        writeToFile("markers");
    }
}
