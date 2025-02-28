package tournament.main;

import tournament.comparators.*;
import tournament.data.*;
import tournament.exceptions.FullTeamException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class TournamentManager {
    Scanner scanner = new Scanner(System.in);

    private final Player[] registeredPlayers;
    private final Team[] registeredTeams;
    private final Tournament[] tournaments;
    private final Match[] matches;

    public TournamentManager() {
        registeredPlayers = new Player[10];
        registeredTeams = new Team[5];
        tournaments = new Tournament[3];
        matches = new Match[5];
    }

    public void initialize() {

        registeredPlayers[0] = new Player("Pepe", 11, -1);
        registeredPlayers[1] = new Player("CacahueteGamer", 101, 2600);
        registeredPlayers[2] = new Player("Patata_frita", -1, 777.777);
        registeredPlayers[3] = new Player("IronMak", 12, 453.453);
        registeredPlayers[4] = new Player("TheNexxCover", 4, 777.777);
        registeredPlayers[5] = new Player("Hiensito", 5, 123.456);
        registeredPlayers[6] = new Player("Macarrón Termorretráctil", 3, 3.1415926);
        registeredPlayers[7] = new Player("Aaros de cebolla", 26, 999.99);
        registeredPlayers[8] = new Player("csvera12", 99, 69420.123);
        registeredPlayers[9] = new Player("Elenituxx<3", 77, 777.777);

        Team team1 = new Team("DoWhileGang");
        Team team2 = new Team("Espartanos");
        Team team3 = new Team("Cacharros");
        Team team4 = new Team("PotatoTeam");
        Team team5 = new Team("RocketRiders");

        try {
            team1.addPlayer(registeredPlayers[0]);
            team1.addPlayer(registeredPlayers[1]);
            team2.addPlayer(registeredPlayers[2]);
            team2.addPlayer(registeredPlayers[3]);
            team3.addPlayer(registeredPlayers[4]);
            team3.addPlayer(registeredPlayers[5]);
            team4.addPlayer(registeredPlayers[6]);
            team4.addPlayer(registeredPlayers[7]);
            team5.addPlayer(registeredPlayers[8]);
            team5.addPlayer(registeredPlayers[9]);
        } catch (FullTeamException e){
            System.err.println("Error adding player: "+e.getMessage());
        }

        registeredTeams[0] = team1;
        registeredTeams[1] = team2;
        registeredTeams[2] = team3;
        registeredTeams[3] = team4;
        registeredTeams[4] = team5;

        tournaments[0] = new IndividualTournament("Individual Battles", "CS:GO", 999.99);
        tournaments[1] = new TeamTournament("Team Wars", "Minecraft", 7777, 2);
        tournaments[2] = new MixedTournament("Mixed Sandwich League", "Valorant", 6942.01, "5v5");

        Random random = new Random();
        for (int i = 0; i < matches.length; i++) {
            Tournament tournament = tournaments[random.nextInt(tournaments.length)];
            Participant participant1;
            Participant participant2;
            if (tournament instanceof IndividualTournament) {
                do
                {
                    participant1 = registeredPlayers[random.nextInt(registeredPlayers.length)];
                    participant2 = registeredPlayers[random.nextInt(registeredPlayers.length)];
                }while(participant1 == participant2);
            }
            else {
                do
                {
                    participant1 = registeredTeams[random.nextInt(registeredTeams.length)];
                    participant2 = registeredTeams[random.nextInt(registeredTeams.length)];
                }while(participant1 == participant2);
            }
            matches[i] = new Match(tournament, participant1, participant2);
        }
    }
    //function to option 5 O5
    public Player findPlayer(String username)
    {
        Player result = null;
        for (Player player : registeredPlayers) {
            if (player.getName().equals(username)) {
                result = player;
            }
        }
        return result;
    }

    public Team findTeam(String teamName)
    {
        Team result = null;
        for (Team team : registeredTeams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                result = team;
            }
        }
        return result;
    }

    public void showTournaments()
    {
        for (Tournament tournament : tournaments)
        {
            System.out.println(tournament);
        }
    }

    //The result of these function will be shown 3 times
    public void showPlayerRanking()
    {
        Arrays.sort(registeredPlayers, new PlayerRankingComparator());
        showParticipantsArray(registeredPlayers);

        Arrays.sort(registeredPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Double.compare(p1.getRanking(), p2.getRanking());
            }
        });
        showParticipantsArray(registeredPlayers);

        Arrays.sort(registeredPlayers, (p1, p2) -> Double.compare(p1.getRanking(), p2.getRanking()));
        showParticipantsArray(registeredPlayers);
    }
    //The result of these function will be shown 3 times
    //function to option 3 O3
    public void showTeamRanking()
    {
        System.out.println("1º-A class that implements Comparator-____________________");
        Arrays.sort(registeredTeams, new TeamRankingComparator());
        showParticipantsArray(registeredTeams);

        System.out.println("2º-An anonymous class-____________________________________");
        Arrays.sort(registeredTeams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                return Double.compare(t1.getAveragePlayerRanking(), t2.getAveragePlayerRanking());
            }
        });
        showParticipantsArray(registeredTeams);

        System.out.println("3º-A lambda expression-___________________________________");
        Arrays.sort(registeredTeams, (t1,t2) -> Double.compare(t1.getAveragePlayerRanking(), t2.getAveragePlayerRanking()));
        showParticipantsArray(registeredTeams);
    }


    //extra function:
    //Show players and teams
    public void showParticipantsArray(Participant[] participants)
    {
        for(Participant participant : participants)
        {
            System.out.println(participant);
        }
    }
    public void showTournamentByNameO1()
    {
        System.out.println("1º-A class that implements Comparator-____________________");
        Arrays.sort(tournaments, new TournamentNameComparator());
        showTournaments();
        System.out.println("2º-An anonymous class-____________________________________");
        Arrays.sort(tournaments, new Comparator<Tournament>() {
            @Override
            public int compare(Tournament t1, Tournament t2) {
                return t1.getName().compareTo(t2.getName());
            }
        });
        showTournaments();
        System.out.println("3º-A lambda expression-___________________________________");
        Arrays.sort(tournaments, (t1,t2)-> t1.getName().compareTo(t2.getName()));
        showTournaments();
    }
    public void showPlayersByRankingAndNameO2()
    {
        System.out.println("1º-A class that implements Comparator-____________________");
        Arrays.sort(registeredPlayers, new PlayerRankingAndNameComparator());
        showParticipantsArray(registeredPlayers);

        System.out.println("2º-An anonymous class-____________________________________");
        Arrays.sort(registeredPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                int result;
                result = Double.compare(p1.getRanking(), p2.getRanking());
                if (result == 0)
                    result = p1.getName().compareTo(p2.getName());
                return result;
            }
        });
        showParticipantsArray(registeredPlayers);

        System.out.println("3º-A lambda expression-___________________________________");
        Arrays.sort(registeredPlayers, (p1,p2)-> {
            int result;
            result = Double.compare(p1.getRanking(), p2.getRanking());
            if (result == 0)
                result = p1.getName().compareTo(p2.getName());
            return result;
        });
        showParticipantsArray(registeredPlayers);
    }
    public void addNewPlayerToTeamO4()
    {
        scanner.nextLine();
        System.out.print("Team: ");
        String teamName = scanner.nextLine();
        Team team =  findTeam(teamName);
        if (team != null)
        {
            System.out.println("Player data");
            System.out.print("Name: ");
            String playerName = scanner.nextLine();
            int playerLevel = 1;
            double playerRanking = 0;
            System.out.print("Level: ");
            String playerLevelInput = scanner.next();
            System.out.print("Ranking: ");
            String playerRankingInput = scanner.next();
            try {
                playerLevel = Integer.parseInt(playerLevelInput);
                playerRanking = Double.parseDouble(playerRankingInput);
            } catch (NumberFormatException e) {
                System.err.println("Invalid Level/Ranking input, using default(Level=1, Ranking=0)");
            }
            Player player = new Player(playerName, playerLevel, playerRanking);
            System.out.println("Player: " + player + " added to: " + team.getName());
            try
            {
                team.addPlayer(player);
            }
            catch (FullTeamException e)
            {
                System.err.println("Error adding player: "+e.getMessage());
            }
        }
        else
        {
            System.out.println("No team found");
        }
    }
    public void findPlayersO6(String text)
    {
        boolean founded=false;
        for (Player player : registeredPlayers) {
            if (player.getName().toLowerCase().contains(text.toLowerCase()))
            {
                System.out.println(player);
                founded=true;
            }
        }
        if(!founded)
            System.out.println("Player not found");
    }
    public void findTeamsO7(String text)
    {
        boolean founded=false;
        for (Team team : registeredTeams) {
            if (team.getName().toLowerCase().contains(text.toLowerCase()))
            {
                System.out.println(team);
                founded=true;
            }
        }
        if(!founded)
            System.out.println("Team not found");
    }
    public void showMatches()
    {
        for(Match match : matches)
        {
            System.out.println(match);
        }
    }
    public void showMatchesByTournamentNameO8()
    {
        System.out.println("1º-A class that implements Comparator-____________________");
        Arrays.sort(matches, new MatchTournamentNameComparator());
        showMatches();

        System.out.println("2º-An anonymous class-____________________________________");
        Arrays.sort(matches, new Comparator<Match>() {
            @Override
            public int compare(Match m1, Match m2) {
                return (m1.getAssociatedTournament().getName()).compareTo(m2.getAssociatedTournament().getName());
            }
        });
        showMatches();

        System.out.println("3º-A lambda expression-___________________________________");
        Arrays.sort(matches, (m1,m2)-> (m1.getAssociatedTournament().getName()).compareTo(m2.getAssociatedTournament().getName()));
        showMatches();
    }
    //function to option 9 O9
    public void inputResult()
    {
        for (int i = 0; i < matches.length; i++)
        {
            if (matches[i].getResult().equalsIgnoreCase("Pending"))
            {
                System.out.println( i+1+ ": " + matches[i]);
            }
        }

        System.out.print("Number of the match you want update: ");
        String matchIndexInput = scanner.next();
        int matchIndex = -1;
        try {
            matchIndex = Integer.parseInt(matchIndexInput)-1;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input");
        }
        if (matchIndex>=0 && matchIndex<matches.length)
        {
            System.out.print("Result: ");
            scanner.nextLine();
            String result = scanner.nextLine();
            matches[matchIndex].setResult(result);
        }
        else
        {
            System.out.println("Invalid match number");
        }
    }
}
