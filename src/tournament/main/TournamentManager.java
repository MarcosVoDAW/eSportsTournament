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

    private Player[] registeredPlayers;
    private Team[] registeredTeams;
    private Tournament[] tournaments;
    private Match[] matches;

    public TournamentManager() {
        registeredPlayers = new Player[10];
        registeredTeams = new Team[5];
        tournaments = new Tournament[3];
        matches = new Match[10];
    }

    public void initialize() {

        registeredPlayers[0] = new Player("Player0", 11, -1);
        registeredPlayers[1] = new Player("Player1", 101, 2600);
        registeredPlayers[2] = new Player("Player2", -1, 777.777);
        registeredPlayers[3] = new Player("Player3", 12, 453.453);
        registeredPlayers[4] = new Player("Player4", 4, 1212.1212);
        registeredPlayers[5] = new Player("Player5", 5, 123.456);
        registeredPlayers[6] = new Player("Player6", 3, 3.1415926);
        registeredPlayers[7] = new Player("Player7", 26, 999.99);
        registeredPlayers[8] = new Player("Player8", 99, 48000);
        registeredPlayers[9] = new Player("Player9", 77, 69420.777);

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
            //?????? me lo pone solo
            //e.printStackTrace();
            System.err.println("Error adding player: "+e.getMessage());
        }

        registeredTeams[0] = team1;
        registeredTeams[1] = team2;
        registeredTeams[2] = team3;
        registeredTeams[3] = team4;
        registeredTeams[4] = team5;

        tournaments[0] = new IndividualTournament("Individual Battles", "CS:GO", 999.99);
        tournaments[1] = new TeamTournament("Team Wars", "Minecraft", 7777, 5);
        tournaments[2] = new MixedTournament("Mixed Sandwich League", "Valorant", 6942.01, "5v5");

        Random random = new Random();
        for (int i = 0; i < matches.length; i++) {
            Tournament tournament = tournaments[random.nextInt(tournaments.length)];
            boolean participantIsPlayer = random.nextBoolean();

            Participant participant1;
            Participant participant2;
            if (participantIsPlayer) {
                participant1 = registeredPlayers[random.nextInt(registeredPlayers.length)];
                participant2 = registeredPlayers[random.nextInt(registeredPlayers.length)];
            }
            else {
                participant1 = registeredTeams[random.nextInt(registeredTeams.length)];
                participant2 = registeredTeams[random.nextInt(registeredTeams.length)];
            }
            matches[i] = new Match(tournament, participant1, participant2);
        }
    }
    //Esta funcion para la opcion 5 del menú O5
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

    //3 formas distintas tambien por si acaso
    //y no se si hay que usar esta ordenacion junto a otra para el 2
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
    //3 formas distintas tambien por si acaso
    //Esta funcion para la opcion 3 del menú O3
    public void showTeamRanking()
    {
        Arrays.sort(registeredTeams, new TeamRankingComparator());
        showParticipantsArray(registeredTeams);
        System.out.println("__________________________________________________________");

        Arrays.sort(registeredTeams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                return Double.compare(t1.getAveragePlayerRanking(), t2.getAveragePlayerRanking());
            }
        });
        showParticipantsArray(registeredTeams);
        System.out.println("__________________________________________________________");

        Arrays.sort(registeredTeams, (t1,t2) -> Double.compare(t1.getAveragePlayerRanking(), t2.getAveragePlayerRanking()));
        showParticipantsArray(registeredTeams);
        System.out.println("__________________________________________________________");
    }


    //funciones extras:
    public void showParticipantsArray(Participant[] participants)
    {
        for(Participant participant : participants)
        {
            System.out.println(participant);
        }
    }
    public void showTournamentByNameO1()
    {
        System.out.println("__________________________________________________________");
        Arrays.sort(tournaments, new TournamentNameComparator());
        showTournaments();
        System.out.println("__________________________________________________________");
        Arrays.sort(tournaments, new Comparator<Tournament>() {
            @Override
            public int compare(Tournament t1, Tournament t2) {
                return t1.getName().compareTo(t2.getName());
            }
        });
        showTournaments();
        System.out.println("__________________________________________________________");
        Arrays.sort(tournaments, (t1,t2)-> t1.getName().compareTo(t2.getName()));
        showTournaments();
    }
    public void showPlayersByRankingAndNameO2()
    {
        Arrays.sort(registeredPlayers, new PlayerRankingAndNameComparator());
        showParticipantsArray(registeredPlayers);
        System.out.println("__________________________________________________________");

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
        System.out.println("__________________________________________________________");

        Arrays.sort(registeredPlayers, (p1,p2)-> {
            int result;
            result = Double.compare(p1.getRanking(), p2.getRanking());
            if (result == 0)
                result = p1.getName().compareTo(p2.getName());
            return result;
        });
        showParticipantsArray(registeredPlayers);
        System.out.println("__________________________________________________________");
    }
    public void addNewPlayerToTeamO4()
    {
        System.out.println("Team: ");
        String teamName = scanner.nextLine();
        Team team =  findTeam(teamName);
        if (team != null)
        {
            System.out.println("Player data");
            System.out.println("Name: ");
            String playerName = scanner.nextLine();
            System.out.println("Level: ");
            int playerLevel = scanner.nextInt();
            System.out.println("Ranking: ");
            double playerRanking = scanner.nextDouble();
            Player player = new Player(playerName, playerLevel, playerRanking);
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
        for (Player player : registeredPlayers) {
            if (player.getName().toLowerCase().contains(text.toLowerCase())) {
                System.out.println(player);
            }
        }
    }
    public void findTeamsO7(String text)
    {
        for (Team team : registeredTeams) {
            if (team.getName().toLowerCase().contains(text.toLowerCase())) {
                System.out.println(team);
            }
        }
    }
    public void showMatchesByTournamentNameO8()
    {
        //hacer funcion pra mostrar el array cada vez??
        Arrays.sort(matches, new MatchTournamentNameComparator());
        for(Match match : matches)
        {
            System.out.println(match);
        }
        System.out.println("__________________________________________________________");

        Arrays.sort(matches, new Comparator<Match>() {
            @Override
            public int compare(Match m1, Match m2) {
                return (m1.getAssociatedTournament().getName()).compareTo(m2.getAssociatedTournament().getName());
            }
        });
        for(Match match : matches)
        {
            System.out.println(match);
        }
        System.out.println("__________________________________________________________");

        Arrays.sort(matches, (m1,m2)-> (m1.getAssociatedTournament().getName()).compareTo(m2.getAssociatedTournament().getName()));
        for(Match match : matches)
        {
            System.out.println(match);
        }
        System.out.println("__________________________________________________________");
    }
    //para opcion 9 O9
    public void inputResult()
    {
        for (int i = 1; i <= matches.length; i++)
        {
            if (matches[i-1].getResult().equalsIgnoreCase("Pending"))
            {
                System.out.println( i+ ": " + matches[i-1]);
            }
        }

        System.out.println("Number of the match you want update: ");
        int matchIndex = scanner.nextInt();
        //comprobar si el index que mete es valido??
        System.out.print("Result: ");
        scanner.nextLine();
        String result = scanner.nextLine();


        matches[matchIndex-1].setResult(result);
    }
}
