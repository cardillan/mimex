package mimex;

import arc.graphics.Color;
import arc.graphics.Colors;

import java.util.Map;
import java.util.TreeMap;

public class ColorsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name").append(';')
                .append("rgba")
                .append(newLine);

        Map<String, Color> map = new TreeMap<>();
        Colors.getColors().each(map::put);
        map.entrySet().stream()
                .filter(e -> !Character.isUpperCase(e.getKey().charAt(0)))
                .forEach(e -> sbr.append(e.getKey()).append(';').append(e.getValue()).append(newLine));

        writeToFile("colors");
    }
}
