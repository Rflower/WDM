package com.wdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests((authz) -> authz.antMatchers("/", "/system/**").permitAll());
		http.authorizeRequests((authz) -> authz.antMatchers("/admin/**").hasRole("ADMIN"));
		
		
		
		http.csrf().disable();
		
		http.formLogin().loginPage("/login").loginProcessingUrl("/login")
		.defaultSuccessUrl("/loginSuccess", true);
//		.defaultSuccessUrl("/success_login", true);
//		.successForwardUrl("/success_login");
//		.failureHandler(customFailureHandler);
		
		http.exceptionHandling().accessDeniedPage("/system/accessDenied");
		http.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/main");
		
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}


