package mimex;

import arc.Core;
import arc.audio.Music;
import arc.struct.Seq;
import mindustry.game.MapObjectives;

public class MusicExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("path")
                .append(newLine);


        Seq<Music> music = new Seq<>();
        Core.assets.getAll(Music.class, music);

        music.forEach(m -> {
            String name = m.file.nameWithoutExtension();
            String path = m.file.pathWithoutExtension();
            sbr.append(name)
                    .append(';').append(path, 0, path.length() - name.length() - 1)
                    .append(newLine);
        });

        writeToFile("music");
    }
}
