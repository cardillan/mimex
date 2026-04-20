package mimex;

import mindustry.logic.LAccess;
import mindustry.logic.QueryType;

import javax.management.Query;
import java.util.Arrays;
import java.util.HashSet;

public class QueryTypeExtractor extends ClassMetadataExtractor {

    public QueryTypeExtractor() {
        super(QueryType.class);
    }

    @Override
    public void extract() {
        sbr.append("name")
                .append(';').append("queryable")
                .append(newLine);


        HashSet<QueryType> queryable = new HashSet<>(Arrays.asList(QueryType.queryable));

        for (QueryType l : QueryType.values()) {
            sbr.append(l.name())
                    .append(';').append(queryable.contains(l))
                    .append(newLine);
        }

        writeToFile("query-types");
    }
}
