/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.model;

import java.io.Serializable;

/**
 *
 * @author b.radomirovic
 */
public class Answer extends AbstractEntity{
    private String content;
    private boolean correct;
    private Question question;

    public Answer() {
    }

    public Answer(String content, boolean correct, Question question) {
        this.content = content;
        this.correct = correct;
        this.question = question;
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
