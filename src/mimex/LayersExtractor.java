package mimex;

import mindustry.logic.TileLayer;

import java.util.Arrays;
import java.util.HashSet;

public class LayersExtractor extends ClassMetadataExtractor {

    public LayersExtractor() {
        super(TileLayer.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("getblock")
                .append(';').append("setblock")
                .append(newLine);


        HashSet<TileLayer> settable = new HashSet<>(Arrays.asList(TileLayer.settable));

        for (TileLayer l : TileLayer.all) {
            sbr.append(l.name())
                    .append(';').append(true)
                    .append(';').append(settable.contains(l))
                    .append(newLine);
        }

        writeToFile("layers");
    }
}
