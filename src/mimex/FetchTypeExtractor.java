package mimex;

import mindustry.logic.FetchType;

public class FetchTypeExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (FetchType type : FetchType.all) {
            sbr.append(type.name())
                    .append(newLine);
        }

        writeToFile("fetch-types");
    }
}
