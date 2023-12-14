package com.caioprogramador.application;

import com.caioprogramador.model.dao.DaoFactory;
import com.caioprogramador.model.dao.SellerDao;
import com.caioprogramador.model.entities.Department;
import com.caioprogramador.model.entities.Seller;

import java.util.Date;
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

        System.out.println("\n=== TEST 4 seller insert ===");

        Seller newSeller = new Seller(null, "Greg","greg@gmail.com", new Date(), 4000.0, department);

        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println("\n=== TEST 5 seller update ===");
        seller = sellerDao.findById(1);

        seller.setName("Ruan");
        sellerDao.update(seller);
        System.out.println("Update");
    }
}
