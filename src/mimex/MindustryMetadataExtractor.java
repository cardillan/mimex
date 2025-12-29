package mimex;

import arc.util.Log;
import mindustry.core.Version;
import mindustry.mod.Mod;

public class MindustryMetadataExtractor extends Mod {
    private static final int expectedVersion = 8;
    private static final int minBuild = 26094;
    private static final int maxBuild = 99999;

    public MindustryMetadataExtractor() {
        Log.info("MindustryMetadataExtractor constructor.");
        Log.info("Mindustry version: " + Version.number + ", build: " + Version.build + ", revision: " + Version.revision + ".");
    }

    @Override
    public void init() {
        super.init();
        if (Version.number == expectedVersion && Version.build >= minBuild && Version.build <= maxBuild) {
            new IconsExtractor().extract();
            new ColorsExtractor().extract();
            new BlocksExtractor().extract();
            new ItemsExtractor().extract();
            new LiquidsExtractor().extract();
            new UnitsExtractor().extract();
            new CommandsExtractor().extract();
            new LAccessExtractor().extract();
            new VarsExtractor().extract();
            new SoundsExtractor().extract();

            new TeamsExtractor().extract();
            new BlockRequirementsExtractor().extract();
            new TextureExtractor().extract();

            new AlignmentExtractor().extract();
            new BlockFlagsExtractor().extract();
            new ConditionsExtractor().extract();
            new ContentsExtractor().extract();
            new CutsceneActionsExtractor().extract();
            new EffectsExtractor().extract();
            new FetchTypeExtractor().extract();
            new GraphicsTypesExtractor().extract();
            new LayersExtractor().extract();
            new LLocateExtractor().extract();
            new LMarkerControlExtractor().extract();
            new LogicRuleExtractor().extract();
            new LUnitControlExtractor().extract();
            new MarkersExtractor().extract();
            new MessageTypeExtractor().extract();
            new OperationsExtractor().extract();
            new RadarSortsExtractor().extract();
            new RadarTargetsExtractor().extract();
            new StatusEffectsExtractor().extract();
            new WeathersExtractor().extract();

            new LogicStatementExtractor().extract();
        } else {
            Log.warn(String.format("Mimex Mindustry version mismatch. Expected: %d (build %d to %d), got: %d (build %d)",
                    expectedVersion, minBuild, maxBuild, Version.number, Version.build));
        }
    }
}
