package com.spring.security.login.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityJDBCConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").and().formLogin().loginPage("/showLoginForm").loginProcessingUrl("/authenticateUser").permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
		
		http.authorizeRequests().antMatchers("/managers/**").hasRole("MANAGER").and().formLogin().loginPage("/showLoginForm").loginProcessingUrl("/authenticateUser").permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
		
		http.authorizeRequests().antMatchers("/ceos/**").hasRole("CEO").and().formLogin().loginPage("/showLoginForm").loginProcessingUrl("/authenticateUser").permitAll().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	@Bean
	public UserDetailsManager userDetailsManager()
	{
		JdbcUserDetailsManager userDetails = new JdbcUserDetailsManager();
		userDetails.setDataSource(dataSource);
		return userDetails;
	}

}
