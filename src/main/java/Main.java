/**
 * Created by Karol on 2017-11-28.
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Generator generator = new Generator();
//        generator.Generate(solution);
//        System.out.println(solution.getAllNodes());
//        System.out.println(solution.getAllRelationships());
        System.out.println(solution.getRelationsForNode("Messi"));
        System.out.println(solution.getRelationsForNode("FC Barcelona"));
//        System.out.println(solution.getPathForNodes("Messi", "Ronaldo"));
//        System.out.println(solution.getPathForNodes("Messi", "Iniesta"));
    }
    //https://github.com/chudy1997/BD2-Lab3.git
}
