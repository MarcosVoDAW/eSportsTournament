package tournament.main;

import tournament.data.*;
import tournament.exceptions.FullTeamException;

public class TournamentManager {
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
        // Initialize registeredPlayers
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
            e.printStackTrace();
        }

        registeredTeams[0] = team1;
        registeredTeams[1] = team2;
        registeredTeams[2] = team3;
        registeredTeams[3] = team4;
        registeredTeams[4] = team5;

        tournaments[0] = new IndividualTournament("Individual Battles", "CS:GO", 999.99);
        tournaments[1] = new TeamTournament("Team Wars", "Minecraft", 7777, 5);
        tournaments[2] = new MixedTournament("Mixed Sandwich League", "Valorant", 6942.01, "5v5");


    }
}
