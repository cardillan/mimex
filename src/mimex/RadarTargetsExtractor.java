package mimex;

import mindustry.logic.RadarTarget;

public class RadarTargetsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);


        for (RadarTarget l : RadarTarget.all) {
            sbr.append(l.name())
                    .append(newLine);
        }

        writeToFile("radar-targets");
    }
}
