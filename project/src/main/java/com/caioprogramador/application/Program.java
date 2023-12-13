package com.caioprogramador.application;

import com.caioprogramador.model.dao.DaoFactory;
import com.caioprogramador.model.dao.SellerDao;
import com.caioprogramador.model.entities.Department;
import com.caioprogramador.model.entities.Seller;

import java.util.List;


public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);

        list.forEach(System.out::println);
        System.out.println("\n=== TEST 3: seller findAll ===");
        List<Seller> sellerList = sellerDao.findAll();

        sellerList.forEach(System.out::println);


    }
}
