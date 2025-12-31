package mimex;

import mindustry.logic.RadarTarget;

public class RadarTargetsExtractor extends ClassMetadataExtractor {

    public RadarTargetsExtractor() {
        super(RadarTarget.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("radar")
                .append(';').append("uradar")
                .append(newLine);


        for (RadarTarget l : RadarTarget.all) {
            sbr.append(l.name())
                    .append(';').append(true)
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("radar-targets");
    }
}
