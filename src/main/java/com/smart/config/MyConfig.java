package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {
	/*
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	

	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUser = User.withUsername("abc")
				.password("abc")
				.roles("USER").build();
		
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		
		return inMemoryUserDetailsManager;
		
		
		
		
	}
	*/
	
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception
	{
		
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/","/static/**", "/css/**", "/js/**", "/img/**", "/icon/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin().loginPage("/login");
			

		return http.build();
		
	}
}
	

	

