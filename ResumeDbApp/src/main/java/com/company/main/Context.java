/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.impl.UserDaoImpl2;
import com.company.dao.inter.UserDaoInter;

/**
 *
 * @author sarkhanrasullu
 */
public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl2();
    }
}
