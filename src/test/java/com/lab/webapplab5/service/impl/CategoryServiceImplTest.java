/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.service.impl;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.model.Question;
import com.lab.webapplab5.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author b.radomirovic
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ctx/application-config.xml")
public class CategoryServiceImplTest {
   @Autowired
   CategoryService categoryService;
   
    public CategoryServiceImplTest() {
    }
    
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class CategoryServiceImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = 1l;
        Category t = new Category("Kategorijaa", new ArrayList<Question>());
        t.setId(id);
        Category cat = categoryService.save(t);
        
        Category expResult = t;
        Category result = categoryService.findById(t.getId());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CategoryServiceImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
       Category t1 = new Category("Kategorijaa1", new ArrayList<Question>());
       Category t2 = new Category("Kategorijaa2", new ArrayList<Question>());
       Category t3 = new Category("Kategorijaa3", new ArrayList<Question>());
       
       t1.setId(1l);
       t2.setId(2l);
       t3.setId(3l);
       
       categoryService.save(t1);
       categoryService.save(t2);
       categoryService.save(t3);
       
        int expResult = 3;
        
        List<Category> result = categoryService.findAll();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class CategoryServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Category t = new Category("Kategorijaa", new ArrayList<Question>());
        
        Category expResult = t;
        t.setId(1l);
        Category result = categoryService.save(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class CategoryServiceImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Category t = new Category("Kategorijaa", new ArrayList<Question>());
        t.setId(1l);
        
        categoryService.save(t);
        categoryService.remove(t);
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
