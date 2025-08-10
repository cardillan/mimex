package mimex;

import mindustry.game.Team;

public class TeamsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("color")
                .append(';').append("emoji")
                .append(';').append("hasPalette")
                .append(';').append("palette0")
                .append(';').append("palette1")
                .append(';').append("palette2")
                .append(newLine);

        for (Team team : Team.all) {
            sbr.append(team.name)
                    .append(';').append(team.id)
                    .append(';').append(team.color)
                    .append(';').append(team.emoji)
                    .append(';').append(team.hasPalette)
                    .append(';').append(team.palette[0])
                    .append(';').append(team.palette[1])
                    .append(';').append(team.palette[2])
                    .append(newLine);
        }

        writeToFile("teams");
    }
}
