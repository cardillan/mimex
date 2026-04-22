package mimex;

import mindustry.logic.QueryShape;
import mindustry.logic.QueryType;

import java.util.Arrays;
import java.util.HashSet;

public class QueryShapeExtractor extends ClassMetadataExtractor {

    public QueryShapeExtractor() {
        super(QueryShape.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(newLine);


        for (QueryShape l : QueryShape.values()) {
            sbr.append(l.name())
                    .append(newLine);
        }

        writeToFile("query-shapes");
    }
}
