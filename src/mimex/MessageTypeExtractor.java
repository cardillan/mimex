package mimex;

import mindustry.logic.MessageType;

public class MessageTypeExtractor extends ClassMetadataExtractor {

    public MessageTypeExtractor() {
        super(MessageType.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("message")
                .append(newLine);

        for (MessageType type : MessageType.all) {
            sbr.append(type.name())
                    .append(';').append(true)
                    .append(newLine);
        }

        writeToFile("message-types");
    }
}
