package presentation.command;

import facade.CelularFacade;
import java.util.List;
import model.Celular;

public class ListCelularesCommand implements Command {
    private final CelularFacade facade;

    public ListCelularesCommand(CelularFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        System.out.println("--- Listado de Celulares ---");
        List<Celular> all = facade.listar();
        if (all.isEmpty()) {
            System.out.println("No hay celulares registrados.");
        } else {
            all.forEach(c -> System.out.println(c.toString()));
        }
        System.out.println();
    }
}
