package mimex;

import mindustry.logic.LUnitControl;

public class LUnitControlExtractor extends ClassMetadataExtractor {

    public LUnitControlExtractor() {
        super(LUnitControl.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("ucontrol")
                .append(newLine);

        for (LUnitControl type : LUnitControl.all) {
            sbr.append(type.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("unit-control");
    }
}
