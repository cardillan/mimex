package mimex;

import mindustry.Vars;
import mindustry.ctype.UnlockableContent;

public class LogicIdConvertor {

    public static int lookupLogicId(UnlockableContent content) {
        int id = Vars.logicVars.lookupLogicId(content);
        return content == Vars.logicVars.lookupContent(content.getContentType(), id) ? id : -1;
    }
}
