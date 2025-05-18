package mimex;

import mindustry.ctype.ContentType;
import mindustry.logic.GlobalVars;

import java.util.Arrays;
import java.util.HashSet;

public class ContentsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("lookable")
                .append(newLine);

        HashSet<ContentType> lookable = new HashSet<>(Arrays.asList(GlobalVars.lookableContent));


        for (ContentType type : ContentType.all) {
            sbr.append(type.name())
                    .append(';').append(lookable.contains(type))
                    .append(newLine);
        }

        writeToFile("contents");
    }
}
