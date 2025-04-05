package mimex;

import arc.Core;
import arc.files.Fi;
import arc.struct.ObjectMap;
import arc.util.Log;
import mindustry.Vars;
import mindustry.ai.UnitCommand;
import mindustry.core.Version;
import mindustry.logic.LAccess;
import mindustry.logic.LAssembler;
import mindustry.mod.Mod;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.payloads.PayloadMassDriver;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.BuildVisibility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;

public class MindustryMetadataExtractor extends Mod {

    private final int expectedVersion = 7;
    private final String newLine = System.lineSeparator();
    private final StringBuilder sbr = new StringBuilder();

    public MindustryMetadataExtractor() {
        Log.info("MindustryMetadataExtractor constructor.");
    }

    @Override
    public void init() {
        super.init();
        if (Version.number == expectedVersion) {
            writeIcons();
            writeBlocks();
            writeItems();
            writeLiquids();
            writeUnits();
            writeCommands();
            writeLAccess();
            writeVars();
            writeSounds();
        }
    }

    private void writeToFile(String file) {
        Fi fi = Core.files.local("mimex" + expectedVersion + "-" + file + ".txt");
        fi.writeString(sbr.toString());
        Log.info("Created local file " + fi.absolutePath());
        sbr.setLength(0);
    }

    private void writeIcons() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        try (Scanner scan = new Scanner(Core.files.internal("icons/icons.properties").read(512))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] s = line.split("[|=]");
                if (s.length < 3) continue;
                String name = s[2].toUpperCase().replaceAll("-UI$", "");
                sbr.append(name).append(';').append(s[1]).append(';').append(s[0]).append(newLine);
            }
        }

        writeToFile("icons");
    }

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

    private void appendUnitPlans(UnitFactory unitFactory) {
        for (int i = 0; i < unitFactory.plans.size; i++) {
            if (i > 0) sbr.append('|');
            sbr.append(unitFactory.plans.get(i).unit.name);
        }
    }

    private void writeBlocks() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("id")
                .append(';').append("visibility")
                .append(';').append("size")
                .append(';').append("subclass")
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
                .append(newLine);

        Vars.content.blocks().each(block -> {
            sbr.append(block.name)
                    .append(';').append(Vars.logicVars.lookupLogicId(block))
                    .append(';').append(visibilityMap.get(block.buildVisibility))
                    .append(';').append(block.size)
                    .append(';').append(block.subclass.getSimpleName())
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
                    .append(';');
            if (block instanceof UnitFactory f) {
                appendUnitPlans(f);
            }
            sbr.append(newLine);
        });

        writeToFile("blocks");
    }

    private void writeItems() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        Vars.content.items().each(item -> sbr.append(item.name)
                .append(';').append(Vars.logicVars.lookupLogicId(item))
                .append(newLine));

        writeToFile("items");
    }

    private void writeLiquids() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        Vars.content.liquids().each(liquid -> sbr.append(liquid.name)
                .append(';').append(Vars.logicVars.lookupLogicId(liquid))
                .append(newLine));

        writeToFile("liquids");
    }

    private void writeUnits() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        Vars.content.units().each(unit -> sbr.append(unit.name)
                .append(';').append(Vars.logicVars.lookupLogicId(unit))
                .append(newLine));

        writeToFile("units");
    }


    private void writeCommands() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("id")
                .append(newLine);

        UnitCommand.all.each(command -> sbr.append(command.name)
                .append(';').append(command.id)
                .append(newLine));

        writeToFile("commands");
    }

    private void writeLAccess() {
        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

        sbr.append("name")
                .append(';').append("senseable")
                .append(';').append("controls")
                .append(';').append("settable")
                .append(';').append("parameters")
                .append(newLine);


        HashSet<LAccess> senseable = new HashSet<>(Arrays.asList(LAccess.senseable));
        HashSet<LAccess> controls = new HashSet<>(Arrays.asList(LAccess.controls));
        HashSet<LAccess> settable = new HashSet<>(Arrays.asList(LAccess.settable));

        for (LAccess l : LAccess.all) {
            sbr.append(l.name())
                    .append(';').append(senseable.contains(l))
                    .append(';').append(controls.contains(l))
                    .append(';').append(settable.contains(l))
                    .append(';').append(String.join(",", l.params))
                    .append(newLine);
        }

        writeToFile("laccess");
    }

    private void writeVars() {
//        try {
            sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);

            LAssembler lAssembler = LAssembler.assemble("noop", true);
            ObjectMap<String, LAssembler.BVar> lvars = lAssembler.vars;

            sbr.append("name")
                    .append(';').append("global")
                    .append(';').append("isobj")
                    .append(';').append("constant")
                    .append(';').append("numval")
                    .append(newLine);

            lAssembler.vars.forEach(e -> sbr.append(e.key)
                    .append(';').append("global")
                    .append(';').append(false)
                    .append(';').append(e.value.constant)
                    .append(';').append(0.0)
                    .append(newLine));

//            lvars.values().forEach(e -> sbr.append(e.name)
//                    .append(';').append("global")
//                    .append(';').append(e.isobj)
//                    .append(';').append(e.constant)
//                    .append(';').append(e.numval)
//                    .append(newLine));

            writeToFile("vars");
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void writeSounds() {
//        sbr.append("// DO NOT EDIT! Generated by mimex - Mindustry Metadata Extractor").append(newLine);
//        GlobalVars.soundNames.each(e -> sbr.append(e).append(newLine));
//        writeToFile("sounds");
    }
}
