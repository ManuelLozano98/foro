package com.manuel.forum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	// defines which URL paths should be secured and which should not
	protected void configure(HttpSecurity http) throws Exception {
		http	
				.authorizeRequests()
					.antMatchers("/hello").permitAll()
//					.antMatchers("/test").fullyAuthenticated().anyRequest().authenticated()
					.antMatchers("/test").access("hasRole('user')")
					.and()
				.formLogin()
					.loginPage("/login") //Suppress this to bring up the default form
					.permitAll()
					.and()
				.logout()
//					.logoutSuccessUrl("/login?logout")
					.permitAll();
					
	}

	@Bean
	@Override
	//Create an authenticated user in memory
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("user")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
