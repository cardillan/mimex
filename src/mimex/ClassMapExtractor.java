package mimex;

import arc.Core;
import mindustry.logic.ConditionOp;

import java.util.Map;
import java.util.Scanner;

public class ClassMapExtractor extends MetadataExtractor {
    private final Map<String, String> classMap;

    public ClassMapExtractor(Map<String, String> classMap) {
        this.classMap = classMap;
    }

    @Override
    public void extract() {
        sbr.append("class")
                .append(';').append("file")
                .append(newLine);

        classMap.forEach((k, v) -> sbr.append(k).append(';').append(v).append(newLine));

        writeToFile("class-map");
    }
}
