package com.caioprogramador.model.dao;

import com.caioprogramador.db.DB;
import com.caioprogramador.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
