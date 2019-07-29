/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author b.radomirovic
 */

@Component
public class MyLogOutHandler implements LogoutHandler{

    @Override
    public void logout(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) {
        
        a.setAuthenticated(false);
        
    }

   
    
}
