package mimex;

import mindustry.logic.LLocate;

public class LLocateExtractor extends ClassMetadataExtractor {

    public LLocateExtractor() {
        super(LLocate.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("ulocate")
                .append(newLine);

        for (LLocate locate : LLocate.all) {
            sbr.append(locate.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("locate");
    }
}
