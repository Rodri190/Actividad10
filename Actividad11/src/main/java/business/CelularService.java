package business;

import model.Celular;
import java.util.List;
import java.util.Optional;

public interface CelularService {
    void crearCelular(Celular c);
    Optional<Celular> obtenerPorId(String id);
    List<Celular> listarTodos();
    boolean eliminar(String id);
}
