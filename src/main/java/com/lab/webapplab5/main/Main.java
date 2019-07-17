/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.main;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.service.CategoryService;
import com.lab.webapplab5.service.impl.CategoryServiceImpl;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author b.radomirovic
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext appContext=new ClassPathXmlApplicationContext("ctx/application-config.xml");
        CategoryService categoryService=appContext.getBean(CategoryServiceImpl.class);  
        
          Category category=new Category("Kategorija 1", new ArrayList<Question>());
          category.setId(1l);
          categoryService.save(category);
          Category cat2=categoryService.findById(1l);
          System.out.println(cat2.getName());
    }
}
