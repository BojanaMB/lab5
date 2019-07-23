/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service.impl;

import com.lab.webapplab5.model.AbstractEntity;
import com.lab.webapplab5.model.Answer;
import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.CategoryRepository;
import com.lab.webapplab5.service.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b.radomirovic
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category t) throws Exception{
        return categoryRepository.save(t);
    }

    @Override
    public void remove(Category t) throws IllegalArgumentException {
        categoryRepository.delete(t);
    }
    
}
