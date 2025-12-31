package mimex;

import mindustry.logic.LMarkerControl;

public class LMarkerControlExtractor extends ClassMetadataExtractor {

    public LMarkerControlExtractor() {
        super(LMarkerControl.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("setmarker")
                .append(newLine);

        for (LMarkerControl type : LMarkerControl.all) {
            sbr.append(type.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("marker-control");
    }
}
