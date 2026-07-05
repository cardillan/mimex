package mimex;

import arc.Core;
import arc.audio.Sound;
import arc.struct.Seq;
import arc.util.Strings;
import mindustry.gen.Sounds;
import mindustry.logic.GlobalVars;

import java.util.stream.StreamSupport;

public class SoundsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name").append(newLine);
        Seq<String> soundNames = new Seq<>();

        for (var entry : Core.assets.getAllEntries(Sound.class, new Seq<>())) {
            if (entry.value != Sounds.none && entry.value.file != null) {
                soundNames.add(Strings.getFileNameWithoutExtension(entry.key));
            }
        }
        soundNames.sort();
        soundNames.each(e -> sbr.append(e).append(newLine));
        writeToFile("sounds");
    }
}
