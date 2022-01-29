package com.raghava.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AuthenticationManager extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { // TODO Auto-generated method stub
	 * 
	 * auth.inMemoryAuthentication().withUser("kvr").password("kvr123").roles(
	 * "USER") .and().withUser("raghava").password("kvraghava").roles("ADMIN");
	 * 
	 * auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
	 * .withUser(User.withUsername("kvr").password("kvr123").roles("USER"))
	 * .withUser(User.withUsername("raghava").password("kvraghava").roles("ADMIN"));
	 * }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * auth.inMemoryAuthentication().withUser("kvr").password("kvr123").roles(
		 * "USER") .and().withUser("raghava").password("kvraghava").roles("ADMIN");
		 */
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled "+
					" from my_user "+" where username = ?")
				.authoritiesByUsernameQuery("select username,authority "+
						 " from my_auth "+" where username = ?");

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/hello/admin").hasRole("ADMIN").antMatchers("/hello/user")
				.hasAnyRole("USER", "ADMIN").antMatchers("/hello/").permitAll().and().formLogin();

	}
}
