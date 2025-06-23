package mimex;

import mindustry.logic.LMarkerControl;

public class LMarkerControlExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (LMarkerControl type : LMarkerControl.all) {
            sbr.append(type.name())
                    .append(newLine);
        }

        writeToFile("marker-control");
    }
}
