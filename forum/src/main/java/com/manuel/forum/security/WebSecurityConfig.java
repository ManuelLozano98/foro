package com.manuel.forum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.manuel.forum.service.UserDetailsImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	// defines which URL paths should be secured and which should not
	protected void configure(HttpSecurity http) throws Exception {
		http.
				csrf().disable()
				.authorizeRequests()
					.antMatchers("/hello").permitAll()
					.antMatchers(HttpMethod.POST, "/sign-up").permitAll()
					.antMatchers(HttpMethod.POST, "/sign-in").permitAll()
//			.antMatchers("/test").fullyAuthenticated().anyRequest().authenticated()
					.antMatchers("/test").access("hasRole('user')")
					.and()
				.formLogin()
//			.loginPage("/login") //Suppress this to bring up the default form
					.permitAll()
					.and()
				.logout()
//			.logoutSuccessUrl("/login?logout")
					.permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsImpl();
	};

	@Override
	// Tell spring to use Bcrypt encoding mechanism to compare the passwords
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

}
