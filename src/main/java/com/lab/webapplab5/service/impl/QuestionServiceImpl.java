/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service.impl;

import com.lab.webapplab5.model.AbstractEntity;
import com.lab.webapplab5.model.Answer;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.QuestionRepository;
import com.lab.webapplab5.service.AbstractService;
import com.lab.webapplab5.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b.radomirovic
 */

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;
    
   
    @Override
    public List findAll() {
        return questionRepository.findAll();
    }


    @Override
    public void remove(Question t) throws IllegalArgumentException {
        questionRepository.delete(t);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.getOne(id);
    }

    @Override
    public Question save(Question t) throws Exception {
        return questionRepository.save(t);
    }
}
