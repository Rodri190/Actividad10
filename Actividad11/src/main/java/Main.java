import business.CelularServiceImpl;
import data.InMemoryCelularDAO;
import facade.CelularFacade;
import presentation.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        var dao = InMemoryCelularDAO.getInstance();
        var service = new CelularServiceImpl(dao);
        var facade = new CelularFacade(service);
        var ui = new ConsoleUI(facade);
        ui.start();
    }
}
