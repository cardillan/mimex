package mimex;

import mindustry.Vars;
import mindustry.gen.Payloadc;

import static mindustry.Vars.tilePayload;
import static mindustry.Vars.tilesize;

public class UnitsExtractor extends MetadataExtractor {

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("health")
                .append(';').append("size")
                .append(';').append("itemCapacity")
                .append(';').append("speed")
                .append(';').append("payloadCapacity")
                .append(newLine);

        Vars.content.units().each(unit -> sbr.append(unit.name)
                .append(';').append(unit.id)
                .append(';').append(LogicIdConvertor.lookupLogicId(unit))
                .append(';').append(unit.health)
                .append(';').append(unit.hitSize / tilesize)
                .append(';').append(unit.itemCapacity)
                .append(';').append(unit.speed * 60f / tilesize)
                .append(';').append(unit.sample instanceof Payloadc ? unit.payloadCapacity / tilePayload : 0f)
                .append(newLine));

        writeToFile("units");
    }
}
