package mimex;

import mindustry.logic.RadarTarget;
import mindustry.logic.TileLayer;

import java.util.Arrays;
import java.util.HashSet;

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
