package mimex;

import mindustry.logic.LUnitControl;

public class LUnitControlExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (LUnitControl type : LUnitControl.all) {
            sbr.append(type.name())
                    .append(newLine);
        }

        writeToFile("unit-control");
    }
}
