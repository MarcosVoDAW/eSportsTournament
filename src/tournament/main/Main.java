/*
Name:
Marcos Varela
Nehuén Rojas
Lucia...

1ºDAW
 */

package tournament.main;
import tournament.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void mostrarMenu()
    {
        System.out.println("1. View available tournaments ordered by name");
        System.out.println("2. View players information ordered by ranking and name");
        System.out.println("3. View teams information ordered by ranking");
        System.out.println("4. Add a new player to a team");
        System.out.println("5. Find an exact player by name");
        System.out.println("6. Find players");
        System.out.println("7. Find teams");
        System.out.println("8. Show all the matches ordered by tournament name");
        System.out.println("9. Update the result of the matches pending");
        System.out.println("10. Exit");
        System.out.println("__________________________________________________________");
        System.out.print("Choose one of the options to perform: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            mostrarMenu();
            option = scanner.nextInt();

            switch (option)
            {
                case 1:
                    System.out.println("Mostrando torneos ordenados por nombre...");
                    break;
                case 2:
                    System.out.println("Mostrando información de jugadores ordenados por ranking y nombre...");
                    break;
                case 3:
                    System.out.println("Mostrando información de equipos ordenados por ranking...");
                    break;
                case 4:
                    System.out.println("Añadiendo un nuevo jugador a un equipo...");
                    break;
                case 5:
                    System.out.println("Buscando un jugador exacto por nombre...");
                    break;
                case 6:
                    System.out.println("Buscando un jugador...");
                    break;
                case 7:
                    System.out.println("Buscando un equipo...");
                    break;
                case 8:
                    System.out.println("Mostrando todos los partidos ordenados por torneo...");
                    break;
                case 9:
                    System.out.println("Actualizando resultados de partidos pendientes...");
                    break;
                case 10:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }

        }while(option != 10);

    }
}
