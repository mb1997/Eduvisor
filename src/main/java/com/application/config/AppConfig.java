package com.application.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	
	// Function Gives permission to every page and removing its filters and securities which was default.
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	            .antMatchers("/").permitAll()
	            .antMatchers("/login").permitAll()
	            .antMatchers("/register").permitAll()
                .antMatchers("/resources/**").permitAll() 
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index", true)
                .permitAll()
                .and()
            .logout()                                    
                .permitAll();
    }
	
	//Function overrides default path configuration of spring security.
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	
}

