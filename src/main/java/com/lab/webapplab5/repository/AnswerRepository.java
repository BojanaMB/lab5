/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository;

import com.lab.webapplab5.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b.radomirovic
 */
@Repository

public interface AnswerRepository extends JpaRepository<Answer,Long>{
    
}
