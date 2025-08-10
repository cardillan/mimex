package mimex;

import mindustry.Vars;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.legacy.LegacyBlock;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.payloads.PayloadMassDriver;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.BuildVisibility;

import java.util.IdentityHashMap;
import java.util.Map;

public class BlocksExtractor extends MetadataExtractor {
    private final Map<BuildVisibility, String> visibilityMap = new IdentityHashMap<>();

    {
        visibilityMap.put(BuildVisibility.hidden, "hidden");
        visibilityMap.put(BuildVisibility.shown, "shown");
        visibilityMap.put(BuildVisibility.debugOnly, "debugOnly");
        visibilityMap.put(BuildVisibility.editorOnly, "editorOnly");
        visibilityMap.put(BuildVisibility.sandboxOnly, "sandboxOnly");
        visibilityMap.put(BuildVisibility.campaignOnly, "campaignOnly");
        visibilityMap.put(BuildVisibility.lightingOnly, "lightingOnly");
        visibilityMap.put(BuildVisibility.ammoOnly, "ammoOnly");
        visibilityMap.put(BuildVisibility.fogOnly, "fogOnly");
    }

    private double getRange(Block block) {
        if (block instanceof PowerNode p) {
            return p.laserRange;
        } else if (block instanceof ItemBridge b) {
            return b.range;
        } else if (block instanceof MassDriver d) {
            return d.range / Vars.tilesize;
        } else if (block instanceof PayloadMassDriver d) {
            return d.range / Vars.tilesize;
        } else if (block instanceof LogicBlock l) {
            return l.range / Vars.tilesize;
        } else {
            return 0;
        }
    }

    private String unitPlans(Block block) {
        if (block instanceof UnitFactory unitFactory) {
            StringBuilder sbr = new StringBuilder();
            for (int i = 0; i < unitFactory.plans.size; i++) {
                if (i > 0) sbr.append('|');
                sbr.append(unitFactory.plans.get(i).unit.name);
            }
            return sbr.toString();
        } else {
            return "";
        }
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("id")
                .append(';').append("logicId")
                .append(';').append("visibility")
                .append(';').append("size")
                .append(';').append("subclass")
                .append(';').append("legacy")
                .append(';').append("configurable")
                .append(';').append("category")
                .append(';').append("range")
                .append(';').append("hasItems")
                .append(';').append("acceptsItems")
                .append(';').append("separateItemCapacity")
                .append(';').append("itemCapacity")
                .append(';').append("noSideBlend")
                .append(';').append("unloadable")
                .append(';').append("hasLiquids")
                .append(';').append("outputsLiquid")
                .append(';').append("liquidCapacity")
                .append(';').append("hasPower")
                .append(';').append("consumesPower")
                .append(';').append("outputsPower")
                .append(';').append("connectedPower")
                .append(';').append("conductivePower")
                .append(';').append("maxNodes")
                .append(';').append("outputFacing")
                .append(';').append("rotate")
                .append(';').append("unitPlans")
                .append(';').append("color")
                .append(';').append("outlineColor")
                .append(';').append("lightColor")
                .append(';').append("health")
                .append(';').append("solid")
                .append(';').append("powerCapacity")
                .append(';').append("powerStorage")
                .append(';').append("configSenseable")
                .append(newLine);

        Vars.content.blocks().each(block -> {
            sbr.append(block.name)
                    .append(';').append(block.id)
                    .append(';').append(LogicIdConvertor.lookupLogicId(block))
                    .append(';').append(visibilityMap.get(block.buildVisibility))
                    .append(';').append(block.size)
                    .append(';').append(block.subclass.getSimpleName())
                    .append(';').append(block instanceof LegacyBlock)
                    .append(';').append(block.configurable)
                    .append(';').append(block.category)
                    .append(';').append(getRange(block))
                    .append(';').append(block.hasItems)
                    .append(';').append(block.acceptsItems)
                    .append(';').append(block.separateItemCapacity)
                    .append(';').append(block.itemCapacity)
                    .append(';').append(block.noSideBlend)
                    .append(';').append(block.unloadable)
                    .append(';').append(block.hasLiquids)
                    .append(';').append(block.outputsLiquid)
                    .append(';').append(block.liquidCapacity)
                    .append(';').append(block.hasPower)
                    .append(';').append(block.consumesPower)
                    .append(';').append(block.outputsPower)
                    .append(';').append(block.connectedPower)
                    .append(';').append(block.conductivePower)
                    .append(';').append(block instanceof PowerNode p ? p.maxNodes : 0)
                    .append(';').append(block.outputFacing)
                    .append(';').append(block.rotate)
                    .append(';').append(unitPlans(block))
                    .append(';').append(block.mapColor)
                    .append(';').append(block.outlineColor)
                    .append(';').append(block.lightColor)
                    .append(';').append(block.health)
                    .append(';').append(block.solid)
                    .append(';').append(block.consPower == null ? 0f : block.consPower.usage)
                    .append(';').append(block.consPower == null ? 0f : block.consPower.capacity)
                    .append(';').append(block.configSenseable())
                    .append(newLine);
        });

        writeToFile("blocks");

    }
}
