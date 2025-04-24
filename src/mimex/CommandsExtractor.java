package mimex;

import mindustry.Vars;

public class CommandsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        Vars.content.unitCommands().each(command -> sbr.append(command.name)
                .append(';').append(command.id)
                .append(newLine));

        writeToFile("commands");
    }
}
