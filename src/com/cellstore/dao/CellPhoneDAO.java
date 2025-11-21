package com.cellstore.dao;

import com.cellstore.model.CellPhone;
import java.util.List;

public interface CellPhoneDAO {
    void save(CellPhone phone);
    CellPhone findById(String id);
    List<CellPhone> findAll();
    void update(CellPhone phone);
    void delete(String id);
}
