package mimex;

import arc.util.Log;
import mindustry.core.Version;
import mindustry.mod.Mod;

public class MindustryMetadataExtractor extends Mod {
    private static final int expectedVersion = 8;

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
            new SoundsExtractor().extract();

            new AlignmentExtractor().extract();
            new BlockFlagsExtractor().extract();
            new ContentsExtractor().extract();
            new LayersExtractor().extract();
            new MarkersExtractor().extract();
            new RadarSortsExtractor().extract();
            new RadarTargetsExtractor().extract();
            new StatusEffectsExtractor().extract();
            new WeathersExtractor().extract();
        } else {
            Log.warn("Mimex Mindustry version mismatch. Expected: " + expectedVersion + ", got: " + Version.number);
        }
    }
}
