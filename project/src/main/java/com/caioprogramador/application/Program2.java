package com.caioprogramador.application;

import com.caioprogramador.model.dao.DaoFactory;
import com.caioprogramador.model.dao.DepartmentDao;
import com.caioprogramador.model.dao.SellerDao;
import com.caioprogramador.model.entities.Department;
import com.caioprogramador.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("=== TEST 1: department findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();

        departmentList.forEach(System.out::println);

        System.out.println("\n=== TEST 3 department insert ===");

        Department department = new Department(null, "Mecânica");

//        departmentDao.insert(department);
        System.out.println("Inserted! New id = " + department.getId());
        System.out.println("\n=== TEST 4 department update ===");
        department = departmentDao.findById(1);

        department.setName("Tech");
        departmentDao.update(department);
        System.out.println("Update");

        System.out.println("\n=== TEST 5 department delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


        sc.close();
    }
}
