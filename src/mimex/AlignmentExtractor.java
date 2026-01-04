package mimex;

import mindustry.logic.LStatement;

public class AlignmentExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("draw")
                .append(newLine);

        for (String name : LStatement.nameToAlign.keys()) {
            sbr.append(name)
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("alignments");
    }
}
