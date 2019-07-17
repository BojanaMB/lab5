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
public class TestQuestion extends AbstractEntity{
    private Test test;
    private Question question;

    public TestQuestion() {
    }

    public TestQuestion(Test test, Question question) {
        this.test = test;
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
    
}
