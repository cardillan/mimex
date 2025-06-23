package mimex;

import mindustry.logic.MessageType;

public class MessageTypeExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);

        for (MessageType type : MessageType.all) {
            sbr.append(type.name())
                    .append(newLine);
        }

        writeToFile("message-types");
    }
}
