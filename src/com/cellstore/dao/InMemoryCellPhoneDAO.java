package com.cellstore.dao;

import com.cellstore.model.CellPhone;
import java.util.*;

public class InMemoryCellPhoneDAO implements CellPhoneDAO {
    private final Map<String, CellPhone> store = new HashMap<>();

    @Override
    public void save(CellPhone phone) {
        store.put(phone.getId(), phone);
    }

    @Override
    public CellPhone findById(String id) {
        return store.get(id);
    }

    @Override
    public List<CellPhone> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(CellPhone phone) {
        store.put(phone.getId(), phone);
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
