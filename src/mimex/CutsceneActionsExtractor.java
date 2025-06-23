package mimex;

import mindustry.logic.CutsceneAction;

public class CutsceneActionsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (CutsceneAction action : CutsceneAction.all) {
            sbr.append(action.name())
                    .append(newLine);
        }

        writeToFile("cutscene-actions");
    }
}
