package mimex;

import arc.util.Log;
import mindustry.core.Version;
import mindustry.mod.Mod;

public class MindustryMetadataExtractor extends Mod {
    private static final int expectedVersion = 7;
    private static final int minBuild = 146;
    private static final int maxBuild = 146;

    public MindustryMetadataExtractor() {
        Log.info("MindustryMetadataExtractor constructor.");
    }

    @Override
    public void init() {
        super.init();
        if (Version.number == expectedVersion) {
            new IconsExtractor().extract();
            new ColorsExtractor().extract();
            new BlocksExtractor().extract();
            new ItemsExtractor().extract();
            new LiquidsExtractor().extract();
            new UnitsExtractor().extract();
            new CommandsExtractor().extract();
            new LAccessExtractor().extract();
            new VarsExtractor().extract();

            new TeamsExtractor().extract();
            new BlockRequirementsExtractor().extract();
            new TextureExtractor().extract();

            new BlockFlagsExtractor().extract();
            new ConditionsExtractor().extract();
            new ContentsExtractor().extract();
            new CutsceneActionsExtractor().extract();
            new EffectsExtractor().extract();
            new FetchTypeExtractor().extract();
            new GraphicsTypesExtractor().extract();
            new LayersExtractor().extract();
            new LLocateExtractor().extract();
            new LogicRuleExtractor().extract();
            new LUnitControlExtractor().extract();
            new MessageTypeExtractor().extract();
            new OperationsExtractor().extract();
            new RadarSortsExtractor().extract();
            new RadarTargetsExtractor().extract();
            new StatusEffectsExtractor().extract();
        } else {
            Log.warn(String.format("Mimex Mindustry version mismatch. Expected: %d (build %d to %d), got: %d (build %d)",
                    expectedVersion, minBuild, maxBuild, Version.number, Version.build));
        }
    }
}
