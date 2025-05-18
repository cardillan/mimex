package mimex;

import arc.struct.ObjectMap;
import mindustry.Vars;
import mindustry.logic.LStatements;
import mindustry.logic.LVar;

import java.lang.reflect.Field;

public class AlignmentExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        try {
            sbr.append("name")
                    .append(newLine);

            Field alignsField = LStatements.DrawStatement.class.getDeclaredField("aligns");
            alignsField.setAccessible(true);
            String[] aligns = (String[]) alignsField.get(new LStatements.DrawStatement());

            for (String name : aligns) {
                sbr.append(name)
                        .append(newLine);
            }

            writeToFile("alignments");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
