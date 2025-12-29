package mimex;

import arc.func.Prov;
import mindustry.gen.LogicIO;
import mindustry.logic.LStatement;

public class LogicStatementExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        for (Prov<LStatement> provider : LogicIO.allStatements) {
            LStatement statement = provider.get();
            statement.write(sbr);
            sbr.append("\n");
        }

        writeToFile("logic-statements");
    }
}
