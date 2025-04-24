package mimex;

import mindustry.logic.GlobalVars;

import java.util.stream.StreamSupport;

public class SoundsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        StreamSupport.stream(GlobalVars.soundNames.spliterator(), false).sorted().forEach(e -> sbr.append(e).append(newLine));
        writeToFile("sounds");
    }
}
