package com.caioprogramador.model.dao.impl;

import com.caioprogramador.db.DB;
import com.caioprogramador.db.DbException;
import com.caioprogramador.model.dao.DepartmentDao;
import com.caioprogramador.model.entities.Department;
import com.caioprogramador.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getName());


            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }else
                throw new DbException("Unexpected error! No rows affected!");

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE department "+
                            "SET Name = ? "+
                            "WHERE Id = ?"
            );

            st.setString(1, obj.getName());
            st.setInt(2,obj.getId());

            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?"
            );
            st.setInt(1,id);
            st.executeUpdate();


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * "+
                            "FROM department "+
                            "WHERE id = ?"
            );
            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                return new Department(rs.getInt("Id"), rs.getString("Name"));
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * "+
                            "FROM department "+
                            "ORDER BY Id"
            );
            rs = st.executeQuery();
            List<Department> departmentList = new ArrayList<>();
            while(rs.next()){
                Department department = new Department(rs.getInt("Id"), rs.getString("Name"));
                departmentList.add(department);
            }
            return departmentList;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
