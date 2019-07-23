/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author b.radomirovic
 */
@Entity(name="Category")
@Table(name="category")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Category implements Serializable{
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_category;
    @Column
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Question> questions;
    
    public Category() {
    }

    public Category(long id_category, String name, List<Question> questions) {
        this.id_category = id_category;
        this.name = name;
        this.questions = questions;
    }

    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
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
