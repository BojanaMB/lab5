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
import com.lab.webapplab5.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author b.radomirovic
 */

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;
    
    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question t) throws Exception{
        List<Answer>answers=t.getAnswers();
        if(answers.size()<4) throw new Exception("Pitanje mora imati 4 odgovora!");
        
        int nasaoTacan=0;
        for (Answer answer : t.getAnswers()) {
            if(answer.isCorrect()) nasaoTacan++;
        }
        
        if(nasaoTacan==0 || nasaoTacan>1) throw new Exception("Pitanje mora imati 1 tacan odgovor!");
        
        return questionRepository.save(t);
    }

    @Override
    public void remove(Question t) throws IllegalArgumentException {
        questionRepository.remove(t);
    }
   
   
}
