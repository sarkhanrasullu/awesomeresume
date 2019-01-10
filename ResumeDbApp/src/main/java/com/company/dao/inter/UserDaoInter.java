/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.bean.User;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface UserDaoInter {

    public List<User> getAll();

    public User getById(int id);

    public boolean updateUser(User u);

    public boolean removeUser(int id);

}
