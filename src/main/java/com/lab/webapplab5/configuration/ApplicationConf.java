/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author b.radomirovic
 */
@Configuration
@ComponentScan(basePackages = {
    "com.lab.webapplab5.service","com.lab.webapplab5.repository","com.lab.webapplab5.filter"})
//@ImportResource({"classpath:ctx/persistence-config.xml"})
@Import(value = {JpaConfig.class,SecurityConfiguration.class})
public class ApplicationConf {
    
}
