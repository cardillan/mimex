package mimex;

import mindustry.Vars;
import mindustry.ai.UnitCommand;

public class CommandsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        UnitCommand.all.each(command -> sbr.append(command.name)
                .append(';').append(command.id)
                .append(newLine));

        writeToFile("commands");
    }
}
