/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b.radomirovic
 */
@Entity(name="Question")
@Table(name="question")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Question implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_question;
   @Column
    private String content;
   @ManyToOne
   @JoinColumn(name="id_category",referencedColumnName="id_category")
    private Category category;
   
   @JsonIgnore
   @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<Answer> answers;
    @JsonIgnore
   @ManyToMany(mappedBy = "questions")
     private List<Test> tests;
    
    public Question() {
    }

    public Question(long id_question, String content, Category category, List<Answer> answers, List<Test> tests) {
        this.id_question = id_question;
        this.content = content;
        this.category = category;
        this.answers = answers;
        this.tests = tests;
    }

    public long getId_question() {
        return id_question;
    }

    public void setId_question(long id_question) {
        this.id_question = id_question;
    }

    
    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Test> getTests() {
        return tests;
    }


    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
