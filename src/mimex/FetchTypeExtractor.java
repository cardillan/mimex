package mimex;

import mindustry.logic.FetchType;

public class FetchTypeExtractor extends ClassMetadataExtractor {

    public FetchTypeExtractor() {
        super(FetchType.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("fetch")
                .append(newLine);

        for (FetchType type : FetchType.all) {
            sbr.append(type.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("fetch-types");
    }
}
