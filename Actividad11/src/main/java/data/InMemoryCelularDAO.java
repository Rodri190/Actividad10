package data;

import model.Celular;
import java.util.*;

public final class InMemoryCelularDAO implements CelularDAO {
    private final Map<String, Celular> storage = new LinkedHashMap<>();

    private static InMemoryCelularDAO instance;

    private InMemoryCelularDAO() {}

    public static synchronized InMemoryCelularDAO getInstance() {
        if (instance == null) instance = new InMemoryCelularDAO();
        return instance;
    }

    @Override
    public void save(Celular c) {
        storage.put(c.getId(), c);
    }

    @Override
    public Optional<Celular> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Celular> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean deleteById(String id) {
        return storage.remove(id) != null;
    }
}
