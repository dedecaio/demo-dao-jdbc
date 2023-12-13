package com.caioprogramador.application;

import com.caioprogramador.model.dao.DaoFactory;
import com.caioprogramador.model.dao.SellerDao;
import com.caioprogramador.model.entities.Seller;


public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);


    }
}
