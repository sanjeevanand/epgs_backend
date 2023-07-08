package com.arvs.epgs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.arvs.epgs.security.CustomUserDetailService;
import com.arvs.epgs.security.JwtAuthenticationEntryPoint;
import com.arvs.epgs.security.JwtAuthenticationFilter;
import com.arvs.epgs.util.JwtTokenValidationFilter;

@Configuration
@EnableWebSecurity//(debug = true)
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	//for jwt 
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	public static final String[]  public_urls = {"/api/v1/auth/login","/api/v1/auth/register"};
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .addFilterBefore(new JwtTokenValidationFilter(), BasicAuthenticationFilter.class)
	                .addFilterAfter(new JwtAuthenticationFilter(), BasicAuthenticationFilter.class)
	                .authorizeHttpRequests()
	                .requestMatchers(public_urls)
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .httpBasic().and().csrf().disable();
	        http.formLogin();
	    return http.build();
	
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		  .csrf()
		  .disable()
		  .authorizeHttpRequests()
		  .requestMatchers("public_urls")
		  .permitAll()
		  .anyRequest()
		  .authenticated()
		  .and()
		  .sessionManagement()
		   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		   .and()
		    .authenticationProvider(daoAuthenticationProvider())
		   .addFilterBefore(authenticationFilter,  UsernamePasswordAuthenticationFilter.class);
		return http.build();
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers(public_urls)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      // http.addFilter(UsernamePasswordAuthenticationToken.class);
		http.addFilterBefore(authenticationFilter,  UsernamePasswordAuthenticationFilter.class);
		http.authenticationProvider(daoAuthenticationProvider());
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		//http.authenticationProvider(daoAuthenticationProvider());
		
	return defaultSecurityFilterChain;
	*/
		
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
