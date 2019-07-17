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
public class Question extends AbstractEntity{
   
    private String content;
    private Category category;
    private List<Answer> answers;
    
    
    public Question() {
    }

    public Question(String content, Category category, List<Answer> answers) {
        this.content = content;
        this.category = category;
        this.answers = answers;
    }


    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
