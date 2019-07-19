/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service.impl;

import com.lab.webapplab5.model.AbstractEntity;
import com.lab.webapplab5.model.TestQuestion;
import com.lab.webapplab5.repository.TestQuestionRepository;
import com.lab.webapplab5.service.TestQuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author b.radomirovic
 */
@Service
public class TestQuestionServiceImpl implements TestQuestionService{
    @Autowired
    TestQuestionRepository testQRepository;

    @Override
    public TestQuestion findById(Long id) {
        return testQRepository.findById(id);
    }

    @Override
    public List<TestQuestion> findAll() {
        return testQRepository.findAll();
    }

    @Override
    public TestQuestion save(TestQuestion t)  throws Exception{
        return testQRepository.save(t);
    }

    @Override
    public void remove(TestQuestion t) throws IllegalArgumentException {
        testQRepository.remove(t);
    }
    
    
}
