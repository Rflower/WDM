package com.wdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig  {

	private SecurityUserDetailsService securityUserDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests((authz) -> authz.antMatchers("/", "/system/**").permitAll());
		http.authorizeRequests((authz) -> authz.antMatchers("/admin/**").hasRole("ADMIN"));
		
		
		
		http.csrf().disable();
		
		http.formLogin().loginPage("/login").loginProcessingUrl("/login")
		.defaultSuccessUrl("/loginSuccess", true);
		
		http.exceptionHandling().accessDeniedPage("/system/accessDenied");
		http.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/main");
		
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	
}