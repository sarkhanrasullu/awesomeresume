/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;


import com.company.entity.Country;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface CountryDaoInter {
     
    List<Country> getAll();
     
    public Country getById(int id);
     
    boolean updateCountry(Country u);
     
    boolean removeCountry(int id);
    
}