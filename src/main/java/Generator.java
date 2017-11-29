/**
 * Created by Karol on 2017-11-29.
 */
public class Generator {
    public void Generate(Solution solution){
        solution.createPlayer("Messi", "Argentina");
        solution.createPlayer("Ronaldo", "Portugal");
        solution.createPlayer("Lewandowski", "Poland");
        solution.createPlayer("Neuer", "Germany");
        solution.createPlayer("Iniesta", "Spain");
        solution.createPlayer("Benzema", "France");
        solution.createPlayer("Deulofeu", "Spain");
        solution.createPlayer("Ramos", "Spain");
        solution.createPlayer("Suarez", "Uruguay");
        solution.createPlayer("Robben", "Holland");

        solution.createTeam("FC Barcelona", "Spain", 1899);
        solution.createTeam("Real Madrid", "Spain", 1902);
        solution.createTeam("FC Bayern", "Germany", 1900);

        solution.createCompetes("FC Barcelona", "Real Madrid");
        solution.createCompetes("FC Barcelona", "FC Bayern");
        solution.createCompetes("Real Madrid", "FC Bayern");

        solution.createPlaysInAndEmployes("Messi", "FC Barcelona", 2003);
        solution.createPlaysInAndEmployes("Iniesta", "FC Barcelona", 2002);
        solution.createPlaysInAndEmployes("Suarez", "FC Barcelona", 2014);
        solution.createPlaysInAndEmployes("Deulofeu", "FC Barcelona", 2011);
        solution.createPlaysInAndEmployes("Ronaldo", "Real Madrid", 2009);
        solution.createPlaysInAndEmployes("Benzema", "Real Madrid", 2009);
        solution.createPlaysInAndEmployes("Ramos", "Real Madrid", 2005);
        solution.createPlaysInAndEmployes("Lewandowski", "FC Bayern", 2014);
        solution.createPlaysInAndEmployes("Neuer", "FC Bayern", 2011);
        solution.createPlaysInAndEmployes("Robben", "FC Bayern", 2009);

        solution.createIsBetterThan("Messi", "Ronaldo");
        solution.createIsBetterThan("Messi", "Iniesta");
        solution.createIsBetterThan("Iniesta", "Ronaldo");
        solution.createIsBetterThan("Ronaldo","Suarez");
        solution.createIsBetterThan("Ronaldo", "Lewandowski");
        solution.createIsBetterThan("Suarez", "Lewandowski");
    }
}
