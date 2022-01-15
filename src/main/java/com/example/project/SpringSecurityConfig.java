package com.example.project;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
	private AuthenticationEntryPoint authEntryPoint;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("username").password("password").roles("USER");
	}

}
