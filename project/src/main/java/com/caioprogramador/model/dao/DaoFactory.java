package com.caioprogramador.model.dao;

import com.caioprogramador.db.DB;
import com.caioprogramador.model.dao.impl.DepartmentDaoJDBC;
import com.caioprogramador.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
