package mimex;

import arc.Core;
import arc.graphics.g2d.TextureAtlas;
import arc.struct.ObjectMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TextureExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        try {
            sbr.append("name")
                    .append(';').append("width")
                    .append(';').append("height")
                    .append(newLine);

            Field field = TextureAtlas.class.getDeclaredField("regionmap");
            field.setAccessible(true);
            ObjectMap<String, TextureAtlas.AtlasRegion> map = (ObjectMap<String, TextureAtlas.AtlasRegion>) field.get(Core.atlas);

            List<TextureAtlas.AtlasRegion> data = new ArrayList<>();
            map.values().forEach(data::add);
            data.sort(Comparator.comparing(a -> a.name));

            for (TextureAtlas.AtlasRegion region : data) {
                sbr.append(region.name)
                        .append(';').append(region.width)
                        .append(';').append(region.height)
                        .append(newLine);
            }

            writeToFile("textures");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}