package com.cellstore.dao;

import com.cellstore.model.CellPhone;
import java.util.List;

/**
 * DAO (Data Access Object) - patrón estructural:
 * Define una abstracción para acceder a la "fuente de datos" de CellPhone.
 * Permite desacoplar la lógica de negocio de la forma concreta de almacenamiento.
 *
 * Según la guía (páginas 48–51) el DAO encapsula todo el acceso a la fuente de datos,
 * facilitando tests y cambios del motor de persistencia sin afectar la lógica de negocio.
 */
public interface CellPhoneDAO {
    void save(CellPhone phone);
    CellPhone findById(String id);
    List<CellPhone> findAll();
    void update(CellPhone phone);
    void delete(String id);
}
