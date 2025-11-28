package business;

import data.CelularDAO;
import model.Celular;
import java.util.List;
import java.util.Optional;

public class CelularServiceImpl implements CelularService {
    private final CelularDAO dao;

    public CelularServiceImpl(CelularDAO dao) {
        this.dao = dao;
    }

    @Override
    public void crearCelular(Celular c) {
        if (c == null) throw new IllegalArgumentException("Celular no puede ser null");
        dao.save(c);
    }

    @Override
    public Optional<Celular> obtenerPorId(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Celular> listarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean eliminar(String id) {
        return dao.deleteById(id);
    }
}
