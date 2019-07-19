/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.controller;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author b.radomirovic
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping("/categories")
    public ModelAndView ispisi()
    {
        ModelAndView model=new ModelAndView();
        
        String s="";
        List<Category> category=categoryService.findAll();
        for (Category category1 : category) {
            s+=category1.getName()+"\n";
        }
        
        model.addObject("categories", s);
        model.setViewName("index");
        return model;
    }
}
