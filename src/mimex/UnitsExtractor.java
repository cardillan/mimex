package mimex;

import mindustry.Vars;

public class UnitsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(newLine);

        Vars.content.units().each(unit -> sbr.append(unit.name)
                .append(';').append(unit.id)
                .append(';').append(-1)
                .append(newLine));

        writeToFile("units");
    }
}
