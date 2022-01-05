package com.todo.rest.webservices.restapi.todoAPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class APISecurityConfig extends WebSecurityConfigurerAdapter
	{
		/**
		 * Authentication : set user/password details and mention the role.
		 */
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			auth.inMemoryAuthentication().withUser("saiTest").password("").roles("Tods");
		}

		// Authorization : mention which role can access which URL
		protected void configure(HttpSecurity http) throws Exception
		{
			http
			.csrf().disable()	
			.authorizeRequests()
					.anyRequest().authenticated()
					.and()
				.httpBasic();
		}
		

	
}
