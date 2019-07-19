/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author b.radomirovic
 */
public class Category extends AbstractEntity{
    private String name;
    private List<Question> questions;
    
    public Category() {
    }

    @Override
    public void setId(long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public Category(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
    
    

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
