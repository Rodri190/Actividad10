package presentation;

import facade.CelularFacade;
import java.util.Scanner;
import presentation.command.*;

public class ConsoleUI {
    private final CelularFacade facade;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(CelularFacade facade) {
        this.facade = facade;
    }

    public void start() {
        while (true) {
            System.out.println("---CellStore---");
            System.out.println("1) Agregar celular");
            System.out.println("2) Listar celulares");
            System.out.println("3) Eliminar celular");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String opt = scanner.nextLine().trim();

            Command cmd = null;
            switch (opt) {
                case "1":
                    cmd = new AddCelularCommand(facade, scanner);
                    break;
                case "2":
                    cmd = new ListCelularesCommand(facade);
                    break;
                case "3":
                    cmd = new DeleteCelularCommand(facade, scanner);
                    break;
                case "0":
                    System.out.println("Vuelva Pronto.");
                    return;
                default:
                    System.out.println("Opción inválida.\n");
            }

            if (cmd != null) cmd.execute();
        }
    }
}
