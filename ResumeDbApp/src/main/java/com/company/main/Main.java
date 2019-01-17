/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.EmploymentHistoryDaoInter;

/**
 *
 * @author sarkhanrasullu
 */
public class Main {//Java Database Connectivity = JDBC API Specification

    public static void main(String[] args) throws Exception {
        EmploymentHistoryDaoInter dao = Context.instanceEmploymentHistoryDao();
            
        System.out.println(dao.getAllEmploymentHistoryByUserId(6));
    }
}


/*
    Connection
    

 */
