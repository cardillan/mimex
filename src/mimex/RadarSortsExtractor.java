package mimex;

import mindustry.logic.RadarSort;

public class RadarSortsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);


        for (RadarSort l : RadarSort.all) {
            sbr.append(l.name())
                    .append(newLine);
        }

        writeToFile("radar-sorts");
    }
}
