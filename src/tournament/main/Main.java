/*
eSports Tournament Management System

Members:
Marcos Varela Orchillés - Usuario de Git "MarcosVaorDAW" y "MarcosVoDAW"
Nehuén Esteban Rojas Marsicano - Usuario de Git "Manuel Gutierrez"
Lucía Navarro Cruz - Usuario de Git "Lucia19-beep"


1ºDAW
 */

package tournament.main;
import java.util.Scanner;

public class Main {
    public static void mostrarMenu()
    {
        System.out.print(
                "\n__________________________________________________________\n" +
                        "1. View available tournaments ordered by name\n" +
                        "2. View players information ordered by ranking and name\n" +
                        "3. View teams information ordered by ranking\n" +
                        "4. Add a new player to a team\n" +
                        "5. Find an exact player by name\n" +
                        "6. Find players\n" +
                        "7. Find teams\n" +
                        "8. Show all the matches ordered by tournament name\n" +
                        "9. Update the result of the matches pending\n" +
                        "10. Exit\n" +
                        "__________________________________________________________\n" +
                        "Choose one of the options: "
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TournamentManager manager = new TournamentManager();
        manager.initialize();

        String option;
        do
        {
            mostrarMenu();
            option = scanner.next();

            switch (option)
            {
                case "1":
                    manager.showTournamentByNameO1();
                    break;
                case "2":
                    manager.showPlayersByRankingAndNameO2();
                    break;
                case "3":
                    manager.showTeamRanking();
                    break;
                case "4":
                    manager.addNewPlayerToTeamO4();
                    break;
                case "5":
                    System.out.print("Enter player name: ");
                    String playerName = scanner.next();
                    System.out.println(manager.findPlayer(playerName) == null ? "Player not found" : manager.findPlayer(playerName));
                    break;
                case "6":
                    System.out.print("Search for player: ");
                    String playerSearch = scanner.next();
                    manager.findPlayersO6(playerSearch);
                    break;
                case "7":
                    System.out.print("Search for team: ");
                    String teamSearch = scanner.next();
                    manager.findTeamsO7(teamSearch);
                    break;
                case "8":
                    manager.showMatchesByTournamentNameO8();
                    break;
                case "9":
                    manager.inputResult();
                    break;
                case "10":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Option not available.Try again");
                    break;
            }

        }while(!option.equals("10"));
    }
}
