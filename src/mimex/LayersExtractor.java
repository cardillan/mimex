package mimex;

import mindustry.logic.LAccess;
import mindustry.logic.TileLayer;

import java.util.Arrays;
import java.util.HashSet;

public class LayersExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("settable")
                .append(newLine);


        HashSet<TileLayer> settable = new HashSet<>(Arrays.asList(TileLayer.settable));

        for (TileLayer l : TileLayer.all) {
            sbr.append(l.name())
                    .append(';').append(settable.contains(l))
                    .append(newLine);
        }

        writeToFile("layers");
    }
}
