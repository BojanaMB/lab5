/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.repository.memory;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b.radomirovic
 */
//@Repository
public class CategoryRepositoryMemory implements CategoryRepository{
    
    private List<Category> lista=new ArrayList<>();
    
    @Override
    public Category findById(Long id) {    
        
        for (Category category : lista) {
            if(category.getId()==id)
                return category;
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return lista;
    }

    @Override
    public Category save(Category e) {
        if(e!=null) {
            lista.add(e);
            return e;
        }
        return null;
    }

    @Override
    public void remove(Category e) throws IllegalArgumentException {
    int nasao=0;
        for (Category category : lista) {
            if(e.getId()==category.getId())
            {
                nasao=1;
                lista.remove(e);
            }
        }
        if(nasao==0) throw new IllegalArgumentException();
    }

    public List<Category> getLista() {
        return lista;
    }
    
}
