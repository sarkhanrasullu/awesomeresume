/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface UserDaoInter {

    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int id);

    public boolean addUser(User u);
    
    public boolean updateUser(User u);

    public boolean removeUser(int id);

}
