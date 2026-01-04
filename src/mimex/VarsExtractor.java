package mimex;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.logic.GlobalVars;
import mindustry.logic.LAssembler;
import mindustry.logic.LExecutor;

import java.lang.reflect.Field;

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

            Field vars = GlobalVars.class.getDeclaredField("vars");
            vars.setAccessible(true);
            @SuppressWarnings("unchecked")
            Seq<LExecutor.Var> globalVars = (Seq<LExecutor.Var>) vars.get(Vars.logicVars);

            globalVars.forEach( e -> sbr.append(e.name)
                    .append(';').append("global")
                    .append(';').append(e.isobj)
                    .append(';').append(e.constant)
                    .append(';').append(e.numval)
                    .append(';').append(!e.isobj || e.objval == null)
                    .append(';').append(false)
                    .append(newLine));

            lAssembler.vars.forEach(e -> sbr.append(e.key)
                    .append(';').append("local")
                    .append(';').append(e.value.value == null)
                    .append(';').append(e.value.constant)
                    .append(';').append(0.0)
                    .append(';').append(true)
                    .append(';').append(false)
                    .append(newLine));

            writeToFile("vars");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
