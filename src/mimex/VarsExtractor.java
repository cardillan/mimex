package mimex;

import arc.struct.ObjectMap;
import mindustry.Vars;
import mindustry.logic.GlobalVars;
import mindustry.logic.LAssembler;
import mindustry.logic.LVar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VarsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        try {
            sbr.append("name")
                    .append(';').append("global")
                    .append(';').append("isobj")
                    .append(';').append("constant")
                    .append(';').append("numval")
                    .append(newLine);

            LAssembler lAssembler = LAssembler.assemble("noop", true);

            Field vars = GlobalVars.class.getDeclaredField("vars");
            vars.setAccessible(true);
            @SuppressWarnings("unchecked")
            ObjectMap<String, LVar> globalVars = (ObjectMap<String, LVar>) vars.get(Vars.logicVars);

            List<LVar> allVars = new ArrayList<>();
            lAssembler.vars.values().forEach(allVars::add);
            globalVars.values().forEach(allVars::add);

            allVars.sort(Comparator.comparing(a -> a.name));
            allVars.forEach(v -> sbr.append(v.name)
                    .append(';').append(globalVars.containsKey(v.name) ? "global" : "local")
                    .append(';').append(v.isobj)
                    .append(';').append(v.constant)
                    .append(';').append(v.numval)
                    .append(newLine));

            writeToFile("vars");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
