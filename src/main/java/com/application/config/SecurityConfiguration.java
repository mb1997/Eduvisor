package com.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.service.UserRepoService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
	
	@Bean
	public UserDetailsService mongoUserDetails() {
	    return new UserRepoService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    UserDetailsService userDetailsService = mongoUserDetails();
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity httpsecurity) throws Exception {
		httpsecurity.authorizeRequests()
					.antMatchers("/").permitAll()
		            .antMatchers("/login").permitAll()
		            .antMatchers("/signup").permitAll()	
					.and().httpBasic();
				httpsecurity.csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
		        .loginPage("/login").failureUrl("/login?error=true")
		        .usernameParameter("email")
		        .passwordParameter("password");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}

