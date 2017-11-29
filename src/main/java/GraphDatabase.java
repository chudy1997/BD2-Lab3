/**
 * Created by Karol on 2017-11-28.
 */

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

public final class GraphDatabase {
    private final GraphDatabaseService graphDatabaseService;
    private static final String GRAPH_DIR_LOC = "./neo4jDb";

    public static GraphDatabase createDatabase() {
        return new GraphDatabase();
    }

    private GraphDatabase() {
        graphDatabaseService = new GraphDatabaseFactory()
                .newEmbeddedDatabaseBuilder(new File(GRAPH_DIR_LOC))
                .setConfig(GraphDatabaseSettings.allow_upgrade, "true")
                .newGraphDatabase();
        registerShutdownHook();
    }

    private void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                graphDatabaseService.shutdown();
            }
        });
    }

    public String runCypher(final String cypher) {
        try (Transaction transaction = graphDatabaseService.beginTx()) {
            final Result result = graphDatabaseService.execute(cypher);
            transaction.success();
            return result.resultAsString();
        }
    }
}