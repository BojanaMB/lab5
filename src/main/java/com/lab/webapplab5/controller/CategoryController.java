/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.controller;

import com.lab.webapplab5.model.Category;
import com.lab.webapplab5.service.CategoryService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author b.radomirovic
 */
@RestController
@RequestMapping(value="/categoryController",headers="Accept=*/*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping(value="/categories",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public List<Category> findAll()
    {
        //ModelAndView model=new ModelAndView();
        
        //String s="";
        List<Category> category=categoryService.findAll();
//        for (Category category1 : category) {
//            s+=category1.getName()+"\n";
//        }
        
//        model.addObject("categories", s);
//        model.setViewName("index");
        return category;
    }
    @PostMapping(value="/save",produces = {MediaType.APPLICATION_JSON},consumes ={MediaType.APPLICATION_JSON} )
    public @ResponseBody Category saveCategory(@RequestBody Category category)
    {
        try {
            categoryService.save(category);
            System.out.println("ok");
            return category;
        } catch (Exception ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Transactional
    @RequestMapping(value="/find/{id}",method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON})
    public Category findById(@PathVariable("id") long id)
    {
        Category category = categoryService.findById(id);
        return category;
    }
}
