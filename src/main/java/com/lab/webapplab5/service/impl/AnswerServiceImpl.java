/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service.impl;

import com.lab.webapplab5.model.AbstractEntity;
import com.lab.webapplab5.model.Answer;
import com.lab.webapplab5.repository.AnswerRepository;
import com.lab.webapplab5.service.AnswerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author b.radomirovic
 */
@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer save(Answer t)  throws Exception{
         return answerRepository.save(t);
    }

    @Override
    public void remove(Answer t) throws IllegalArgumentException {
        answerRepository.remove(t);
    }
 
}
