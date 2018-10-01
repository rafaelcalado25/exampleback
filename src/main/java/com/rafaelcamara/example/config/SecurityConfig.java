package com.rafaelcamara.example.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	
	
	/* Os comentarios nesta página foram feitos para aceitar 
	 * todos os metodos: get, post, put and delete.
	 */
	
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/rest/**",	
			"/rest/pessoa/**",	
	};
	private static final String[] PUBLIC_MATCHERS_POST = {
			"/rest/**",				
	};
	private static final String[] PUBLIC_MATCHERS_PUT = {
			"/rest/**",			
	};
	private static final String[] PUBLIC_MATCHERS_DELETE = {
			"/rest/**",	
			"/rest/pessoa/**",
			"/rest/pessoa/remove/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		if(Arrays.asList(env.getActiveProfiles()).contains("teste2")) {
			http.headers().frameOptions().disable();
		}
		http.cors().and().csrf().disable();
		http.authorizeRequests().
		antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().
		antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll().
		antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll().
		antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll().
		anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


}
