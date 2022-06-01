/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface SkillDaoInter {

    List<Skill> getAll();

    public Skill getById(int id);

    boolean updateSkill(Skill u);

    boolean removeSkill(int id);

    public List<Skill> getByName(String name);

    public boolean insertSkill(Skill skl);
}