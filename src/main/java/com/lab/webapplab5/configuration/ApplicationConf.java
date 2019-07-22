/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author b.radomirovic
 */
@Configuration
@ComponentScan(basePackages = {
    "com.lab.webapplab5.repository","com.lab.webapplab5.service"})
@ImportResource({"classpath:ctx/persistence-config.xml"})
public class ApplicationConf {
    
}
