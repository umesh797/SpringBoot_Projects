package com.mob.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth
	.inMemoryAuthentication()
	.withUser("user1").password("user123").roles("USER")
	.and()
	.withUser("admin").password("admin123").roles("ADMIN");
	
	}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http
	.authorizeRequests()
	.antMatchers("/mobiles/show").permitAll()
	.antMatchers("/mobiles/delete/**").hasRole("ADMIN")
	.and()
	.httpBasic();
	}
/*
//any authenticated user can access the resources
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
*/
@Bean
public PasswordEncoder getPasswordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
/*
//allow to access specific url
@Override
protected void configure(HttpSecurity http) throws Exception {
	
	http
	.authorizeRequests()
	.antMatchers("/show")
	.permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic();
}*/

}
