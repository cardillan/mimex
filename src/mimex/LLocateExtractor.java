package mimex;

import mindustry.logic.LLocate;

public class LLocateExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (LLocate locate : LLocate.all) {
            sbr.append(locate.name())
                    .append(newLine);
        }

        writeToFile("locate");
    }
}
