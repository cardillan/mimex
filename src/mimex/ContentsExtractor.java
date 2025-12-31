package mimex;

import mindustry.ctype.ContentType;

public class ContentsExtractor extends ClassMetadataExtractor {

    public ContentsExtractor() {
        super(ContentType.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("lookup")
                .append(newLine);

        for (ContentType type : ContentType.all) {
            sbr.append(type.name())
                    .append(';').append(false)
                    .append(newLine);
        }

        writeToFile("contents");
    }
}
