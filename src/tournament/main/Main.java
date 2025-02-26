package tournament.main;

public class Main {
    public static void main(String[] args) {
        TournamentManager pepe = new TournamentManager();
        pepe.initialize();
        System.out.println(pepe.findPlayer("Player3"));
        System.out.println(pepe.findTeam("Espartanos"));
        pepe.showTournaments();
        pepe.showPlayerRanking();
        pepe.showTeamRanking();
    }
}
