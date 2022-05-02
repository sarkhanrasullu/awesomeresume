package com.company.dto;

import com.company.entity.Skill;

public class SkillDTO {

    private Integer id;
    private String name;

    public SkillDTO() {
    }

    public SkillDTO(Skill skill){
        this.id = skill.getId();
        this.name = skill.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
