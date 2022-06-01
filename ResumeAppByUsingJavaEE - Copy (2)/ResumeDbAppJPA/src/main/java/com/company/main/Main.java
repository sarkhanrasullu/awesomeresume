/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

/**
 *
 * @author sarkhanrasullu
 */
public class Main {//Java Database Connectivity = JDBC API Specification

    public static void main(String[] args) throws Exception {
        UserDaoInter dao = Context.instanceUserDao();

        User u = dao.findByEmail("sarkhanrasullu@gmail.com");
        Country c = u.getBirthPlace();
        
        System.out.println(c.getId());
        System.out.println(dao.findByEmail("sarkhanrasullu@gmail.com"));;
        System.out.println(dao.findByEmail("sarkhanrasullu@gmail.com"));;
        System.out.println(dao.findByEmail("sarkhanrasullu@gmail.com"));;
        System.out.println(dao.findByEmail("sarkhanrasullu@gmail.com"));;
        System.out.println(dao.findByEmail("sarkhanrasullu@gmail.com"));;
        
        AbstractDAO.closeEmf();
        
    }
}


/*
    Connection
    

 */
