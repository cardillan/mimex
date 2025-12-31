package mimex;

import arc.util.Log;
import mindustry.core.Version;
import mindustry.mod.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MindustryMetadataExtractor extends Mod {
    private static final int expectedVersion = 6;
    private static final int minBuild = 126;
    private static final int maxBuild = 126;

    private static final Map<String, String> classMap = new TreeMap<>();

    public MindustryMetadataExtractor() {
        Log.info("MindustryMetadataExtractor constructor.");
    }

    public static void registerClass(String key, String value) {
        classMap.put(key, value);
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

            new TeamsExtractor().extract();
            new BlockRequirementsExtractor().extract();
            new TextureExtractor().extract();

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

            new LogicStatementExtractor().extract();

            new ClassMapExtractor(classMap).extract();
        } else {
            Log.warn(String.format("Mimex Mindustry version mismatch. Expected: %d (build %d to %d), got: %d (build %d)",
                    expectedVersion, minBuild, maxBuild, Version.number, Version.build));
        }
    }
}
