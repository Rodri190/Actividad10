package presentation.command;

import facade.CelularFacade;
import java.util.Scanner;

public class DeleteCelularCommand implements Command {
    private final CelularFacade facade;
    private final Scanner scanner;

    public DeleteCelularCommand(CelularFacade facade, Scanner scanner) {
        this.facade = facade;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Eliminar Celular ---");
        System.out.print("ID a eliminar: ");
        String id = scanner.nextLine().trim();
        boolean ok = facade.eliminar(id);
        System.out.println(ok ? "---> Eliminado." : "---> No encontrado.");
        System.out.println();
    }
}
