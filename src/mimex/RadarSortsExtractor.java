package mimex;

import mindustry.logic.RadarSort;

public class RadarSortsExtractor extends ClassMetadataExtractor {

    public RadarSortsExtractor() {
        super(RadarSort.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("radar")
                .append(';').append("uradar")
                .append(newLine);


        for (RadarSort l : RadarSort.all) {
            sbr.append(l.name())
                    .append(';').append(true)
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("radar-sorts");
    }
}
