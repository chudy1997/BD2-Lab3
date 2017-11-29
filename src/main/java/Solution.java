import java.time.LocalDateTime;

/**
 * Created by Karol on 2017-11-28.
 */
public class Solution {
    private final GraphDatabase graphDatabase = GraphDatabase.createDatabase();

    public void createPlayer(String name, String country){
        String code = String.format("CREATE (:Player {name: '%s', country: '%s' })", name, country);
        graphDatabase.runCypher(code);
    }

    public void createTeam(String name, String country, int year){
        String code = String.format("CREATE (:Team {name: '%s', country: '%s', estabilished: %d })", name, country, year);
        graphDatabase.runCypher(code);
    }

    public void createCompetes(String team1Name, String team2Name){
        String code = String.format("MATCH (t1:Team {name:'%s'}), (t2:Team {name:'%s'}) CREATE (t1)-[:COMPETES]->(t2), (t2)-[:COMPETES]->(t1)", team1Name, team2Name);
        graphDatabase.runCypher(code);
    }

    public void createIsBetterThan(String player1Name, String player2Name){
        String code = String.format("MATCH (p1:Player {name:'%s'}), (p2:Player {name:'%s'}) CREATE (p1)-[:IS_BETTER_THAN]->(p2)", player1Name, player2Name);
        graphDatabase.runCypher(code);
    }

    public void createPlaysInAndEmployes(String playerName, String teamName, int since){
        String code = String.format("MATCH (t:Team {name:'%s'}), (p:Player {name:'%s'}) CREATE (p)-[:PLAYS_IN{since:%d}]->(t), (t)-[:EMPLOYES]->(p)", teamName, playerName, since);
        graphDatabase.runCypher(code);
    }

    public String getAllNodes(){
        String code = "match (n) return n";
        return graphDatabase.runCypher(code);
    }

    public String getAllRelationships(){
        String code = "match (a)-[r]->(b) return a,r,b";
        return graphDatabase.runCypher(code);
    }

    public String getRelationsForNode(String name){
        String code1 = String.format("match (a) -[r]-> (n {name: '%s'}) return a, r, n\n", name);
        String code2 = String.format("match (a) <-[r]- (n {name: '%s'}) return n, r, a\n", name);
        String res1 = graphDatabase.runCypher(code1);
        String res2 = graphDatabase.runCypher(code2);

        return res1 + '\n' + res2;
    }

    public String getPathForNodes(String name1, String name2){
        String code = String.format("match (a {name: '%s'}), (b {name: '%s'}) return shortestPath((a)-[*..15]-(b))", name1, name2);
        return graphDatabase.runCypher(code);
    }
}
