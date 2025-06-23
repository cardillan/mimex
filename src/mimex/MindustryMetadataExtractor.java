package mimex;

import arc.util.Log;
import mindustry.core.Version;
import mindustry.mod.Mod;

public class MindustryMetadataExtractor extends Mod {
    private static final int expectedVersion = 6;

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
            new LAccessExtractor().extract();
            new VarsExtractor().extract();

            new BlockFlagsExtractor().extract();
            new ConditionsExtractor().extract();
            new ContentsExtractor().extract();
            new GraphicsTypesExtractor().extract();
            new LLocateExtractor().extract();
            new LUnitControlExtractor().extract();
            new OperationsExtractor().extract();
            new RadarSortsExtractor().extract();
            new RadarTargetsExtractor().extract();
            new StatusEffectsExtractor().extract();
        } else {
            Log.warn("Mimex Mindustry version mismatch. Expected: " + expectedVersion + ", got: " + Version.number);
        }
    }
}
