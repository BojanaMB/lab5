/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author b.radomirovic
 */
@Entity(name="Answer")
@Table(name="answer")
//@JsonIgnoreProperties(ignoreUnknown = false)
//@Proxy(lazy = false)
public class Answer implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_answer;
   @Column
    private String content;
   @Column
    private boolean correct;
   @ManyToOne
   @JoinColumn(name="question_id",referencedColumnName = "id_question")
    private Question question;

    public Answer() {
    }

    public Answer(long id_answer, String content, boolean correct, Question question) {
        this.id_answer = id_answer;
        this.content = content;
        this.correct = correct;
        this.question = question;
    }

    public long getId_answer() {
        return id_answer;
    }

    public void setId_answer(long id_answer) {
        this.id_answer = id_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
    
}
