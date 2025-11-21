package com.cellstore.service;

import com.cellstore.dao.CellPhoneDAO;
import com.cellstore.model.CellPhone;
import java.util.List;

/**
 * InventoryService (lógica de inventario).
 *
 * Aquí aplicamos Dependency Injection (DI) — patrón Creacional/IoC:
 * - InventoryService no crea el DAO internamente; en vez de eso, recibe
 *   una implementación de CellPhoneDAO en su constructor (Constructor Injection).
 * - Esto desacopla la lógica de inventario de la implementación de persistencia,
 *   facilita pruebas unitarias (podemos inyectar mocks) y sigue las recomendaciones
 *   del documento sobre DI (páginas 40–41).
 *
 * Nota: se hace DI manual (sin frameworks) para demostrar el patrón.
 */
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
