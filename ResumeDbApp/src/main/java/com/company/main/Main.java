/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.bean.User;
import com.company.dao.inter.UserDaoInter;

/**
 *
 * @author sarkhanrasullu
 */
public class Main {//Java Database Connectivity = JDBC API Specification

    public static void main(String[] args) throws Exception {
//loosely coupling
//thightly coupling
//        
        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> list = userDao.getAll();
//        userDao.removeUser(1);
//        List<User> list2 = userDao.getAll();
//
//        System.out.println("list=" + list);
//        System.out.println("list2=" + list2);

        User u = userDao.getById(2);
        u.setName("Eldar");
        userDao.updateUser(u);
    }
}


/*
    Connection
    

 */
