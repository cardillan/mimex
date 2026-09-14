package mimex;

import mindustry.Vars;
import mindustry.ai.UnitCommand;

public class CommandsExtractor extends ClassMetadataExtractor {

    public CommandsExtractor() {
        super(UnitCommand.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        Vars.content.unitCommands().each(c -> c.minfo.mod == null, command -> sbr.append(command.name)
                .append(';').append(command.id)
                .append(newLine));

        writeToFile("commands");
    }
}
