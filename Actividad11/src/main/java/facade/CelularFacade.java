package facade;

import business.CelularService;
import model.Celular;
import java.util.List;
import java.util.Optional;

// Facade simplifica operaciones para la capa de presentación
public class CelularFacade {
    private final CelularService service;

    public CelularFacade(CelularService service) {
        this.service = service;
    }

    public void crear(String id, String marca, String modelo, double precio) {
        Celular c = new Celular(id, marca, modelo, precio);
        service.crearCelular(c);
    }

    public Optional<Celular> obtener(String id) {
        return service.obtenerPorId(id);
    }

    public List<Celular> listar() {
        return service.listarTodos();
    }

    public boolean eliminar(String id) {
        return service.eliminar(id);
    }
}
