package mimex;

import mindustry.ctype.ContentType;

public class ContentsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("lookable")
                .append(newLine);

        for (ContentType type : ContentType.all) {
            sbr.append(type.name())
                    .append(';').append(false)
                    .append(newLine);
        }

        writeToFile("contents");
    }
}
