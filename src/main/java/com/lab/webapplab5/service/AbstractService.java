/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service;

import com.lab.webapplab5.model.AbstractEntity;
import java.util.List;

/**
 *
 * @author b.radomirovic
 */
public interface AbstractService<T extends AbstractEntity> {
    
    T findById(Long id);
    List<T> findAll();
    T save(T t) throws Exception;
    
    void remove(T t) throws IllegalArgumentException;
}
