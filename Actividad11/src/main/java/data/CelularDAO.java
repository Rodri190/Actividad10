package data;

import model.Celular;
import java.util.List;
import java.util.Optional;

public interface CelularDAO {
    void save(Celular c);
    Optional<Celular> findById(String id);
    List<Celular> findAll();
    boolean deleteById(String id);
}
