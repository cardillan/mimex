package mimex;

import mindustry.logic.LAccess;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LAccessExtractor extends ClassMetadataExtractor {

    public LAccessExtractor() {
        super(LAccess.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("ordinal")
                .append(';').append("isObj")
                .append(';').append("sensor")
                .append(';').append("control")
                .append(';').append("setprop")
                .append(';').append("parameters")
                .append(newLine);


        Set<LAccess> senseable = new HashSet<>(Arrays.asList(LAccess.senseable));
        Set<LAccess> controls = new HashSet<>(Arrays.asList(LAccess.controls));

        for (LAccess l : LAccess.all) {
            sbr.append(l.name())
                    .append(';').append(l.ordinal())
                    .append(';').append(l.isObj)
                    .append(';').append(senseable.contains(l))
                    .append(';').append(controls.contains(l))
                    .append(';').append("")
                    .append(';').append(String.join(",", l.params))
                    .append(newLine);
        }

        writeToFile("laccess");
    }
}
