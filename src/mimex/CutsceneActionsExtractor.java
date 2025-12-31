package mimex;

import mindustry.logic.CutsceneAction;

public class CutsceneActionsExtractor extends ClassMetadataExtractor {

    public CutsceneActionsExtractor() {
        super(CutsceneAction.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("cutscene")
                .append(newLine);

        for (CutsceneAction action : CutsceneAction.all) {
            sbr.append(action.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("cutscene-actions");
    }
}
