/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.webapplab5.configuration;

import com.lab.webapplab5.filter.MyLogOutHandler;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author b.radomirovic
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public MyLogOutHandler myLogOutHandler() {
        return new MyLogOutHandler();
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    .withUser("user").password(passwordEncoder().encode("password")).roles("USER").and().withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
           
	    http.csrf().disable()
	    .authorizeRequests().antMatchers("/").permitAll()
	    .and()
	    .authorizeRequests().antMatchers("/categoryController/**").hasAnyRole("USER","ADMIN")
            .and()
	    .authorizeRequests().antMatchers("/welcome").hasAnyRole("USER","ADMIN")
	    .and()
	    .authorizeRequests().antMatchers("/question/**").hasRole("ADMIN")
	    .and()
	    .httpBasic();
            
            http.logout().permitAll().logoutSuccessUrl("/welcome");
//                       http.logout()
//                    .logoutRequestMatcher(
//                            new AntPathRequestMatcher("/myLogOut")
//                    ).permitAll()
//                    .addLogoutHandler(myLogOutHandler())
//                    .logoutSuccessUrl("/welcome").permitAll().invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID");
       
	   }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
