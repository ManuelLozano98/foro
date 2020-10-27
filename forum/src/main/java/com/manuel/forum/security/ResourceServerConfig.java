package com.manuel.forum.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	// defines which URL paths should be secured and which should not
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/hello")
					.permitAll()
				.antMatchers(HttpMethod.POST, "/sign-up")
					.permitAll()
				.antMatchers(HttpMethod.POST, "/sign-in")
					.permitAll()
				// .antMatchers("/test").fullyAuthenticated().anyRequest().authenticated()
				.antMatchers("/test")
					.access("hasRole('user')")
				.and()	
					.formLogin()
						.permitAll()
						//.loginPage("/login") //Form custom
				.and()
					.logout()
						.permitAll()
						// .logoutSuccessUrl("/login?logout")
				.and()		
					.csrf()
						.disable() //Disable this line when this app is in production
					.cors() // The requests with an Angular client are going to come from another origin URL


		;

	}

}
