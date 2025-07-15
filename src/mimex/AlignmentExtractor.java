package mimex;

import mindustry.logic.LStatement;
import mindustry.logic.LStatements;

import java.lang.reflect.Field;

public class AlignmentExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (String name : LStatement.nameToAlign.keys()) {
            sbr.append(name)
                    .append(newLine);
        }

        writeToFile("alignments");
    }
}
