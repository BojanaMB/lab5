/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b.radomirovic
 */
@Entity(name="Test")
@Table(name="test")
//@JsonIgnoreProperties(ignoreUnknown = false)
//@Proxy(lazy = false)
public class Test implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_test;
    @Column(name="create_date")
    private Date createDate;
    @Column
    private String created_by;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name="test_question", joinColumns = {@JoinColumn (name="id_test",referencedColumnName ="id_test")},inverseJoinColumns = {@JoinColumn(name="id_question",referencedColumnName = "id_question")})
    private List<Question> questions;
    
    public Test() {
    }

    public Test(long id_test, Date createDate, String created_by, String name, List<Question> question) {
        this.id_test = id_test;
        this.createDate = createDate;
        this.created_by = created_by;
        this.name = name;
        this.questions = question;
    }

    public long getId_test() {
        return id_test;
    }

    public void setId_test(long id_test) {
        this.id_test = id_test;
    }

    public List<Question> getQuestion() {
        return questions;
    }

    public void setQuestion(List<Question> question) {
        this.questions = question;
    }

    
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
}
