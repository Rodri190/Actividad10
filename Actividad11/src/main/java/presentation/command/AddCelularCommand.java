package presentation.command;

import facade.CelularFacade;
import java.util.Scanner;

public class AddCelularCommand implements Command {
    private final CelularFacade facade;
    private final Scanner scanner;

    public AddCelularCommand(CelularFacade facade, Scanner scanner) {
        this.facade = facade;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Agregar Celular ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine().trim());
        facade.crear(id, marca, modelo, precio);
        System.out.println("-> Celular agregado.\n");
    }
}
