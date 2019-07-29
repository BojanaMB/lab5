/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author b.radomirovic
 */

@Aspect
public class LoggingAspect {
    
    //moramo da kazemo springu da se ovaj metod izvrsava pre svakog get zahteva, na primer
    //@Before("execution(* com.lab.webapplab5.service.impl.CategoryServiceImpl.findById(..))")
    
    //@Before("execution(* findAll(..))")
    
    @Before("dummy2()")
    public void firstLoggingAdvice()
    {
        System.out.println("------------------->>  ---------------------->> ---------------->> 1st Advice called.");
    }
    
    // @Before("execution(* findAll(..))") ako je ista putanja na kojoj hocemo da izvrsimo apektnu metodu, mozemo da definisemo PointCut na dummy metodi
    @Before("dummy1()")
    public void secondLoggingAdvice()
    {
        System.out.println("*************************************************** 2nd Advice called.");
    }
    
    @Pointcut("execution(* findAll(..))")
    public void dummy1()
    {
        
    }
    @Pointcut("within(com.lab1.webapplab5.service.impl.QuestionServiceImpl.*)")
    public void dummy2()
    {
    }
    
}
