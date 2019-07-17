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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author b.radomirovic
 */
public class Main {
    static Logger logger=LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) throws IOException {
        ApplicationContext appContext=new ClassPathXmlApplicationContext("ctx/application-config.xml");
        CategoryService categoryService=appContext.getBean(CategoryServiceImpl.class);  
        
          Category category=new Category("Kategorija 1", new ArrayList<Question>());
          category.setId(1l);
          categoryService.save(category);
          Category cat2=categoryService.findById(1l);
          //System.out.println(cat2.getName());
          
         // FileHandler fileHandler = new FileHandler("Logg.txt", true);        
           
          
          logger.info(cat2.getName());
          
          cat2=null;
          if(cat2==null) logger.error("Kategorija nije pronadjena.");
    }
}
