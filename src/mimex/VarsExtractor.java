package mimex;

import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
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
                    .append(';').append("isnull")
                    .append(';').append("privileged")
                    .append(newLine);

            LAssembler lAssembler = LAssembler.assemble("noop", true);

            Field varsField = GlobalVars.class.getDeclaredField("vars");
            varsField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ObjectMap<String, LVar> vars = (ObjectMap<String, LVar>) varsField.get(Vars.logicVars);

            Field privilegedNamesField = GlobalVars.class.getDeclaredField("privilegedNames");
            privilegedNamesField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ObjectSet<String> privilegedNames = (ObjectSet<String>) privilegedNamesField.get(Vars.logicVars);

            List<LVar> allVars = new ArrayList<>();
            lAssembler.vars.values().forEach(allVars::add);
            vars.values().forEach(allVars::add);

            allVars.sort(Comparator.comparing(a -> a.name));
            allVars.forEach(v -> sbr.append(v.name)
                    .append(';').append(vars.containsKey(v.name) ? "global" : "local")
                    .append(';').append(v.isobj)
                    .append(';').append(v.constant)
                    .append(';').append(v.numval)
                    .append(';').append(v.obj() == null)
                    .append(';').append(privilegedNames.contains(v.name))
                    .append(newLine));

            writeToFile("vars");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
