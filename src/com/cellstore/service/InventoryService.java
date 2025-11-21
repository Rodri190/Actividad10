package com.cellstore.service;

import com.cellstore.dao.CellPhoneDAO;
import com.cellstore.model.CellPhone;
import java.util.List;

public class InventoryService {
    private final CellPhoneDAO dao;

    public InventoryService(CellPhoneDAO dao) {
        this.dao = dao; // inyectado desde fuera
    }

    public void addPhone(CellPhone phone) {
        dao.save(phone);
    }

    public List<CellPhone> listPhones() {
        return dao.findAll();
    }

    public CellPhone findPhone(String id) {
        return dao.findById(id);
    }

    public boolean reduceStock(String id, int qty) {
        CellPhone p = dao.findById(id);
        if (p == null) return false;
        if (p.getStock() < qty) return false;
        p.decrementStock(qty);
        dao.update(p);
        return true;
    }
}
