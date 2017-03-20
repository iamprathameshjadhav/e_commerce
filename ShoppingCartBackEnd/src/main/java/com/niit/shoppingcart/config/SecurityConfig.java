package com.niit.shoppingcart.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.jdbcAuthentication().dataSource(dataSource)
		 .usersByUsernameQuery(
					"select email, password, true from user where email=?")
		 .authoritiesByUsernameQuery(
					"select email, role from user where email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	 http.authorizeRequests()
		 .antMatchers("/category").access("hasRole(admin)")
			.antMatchers("/addcategory").access("hasRole('admin')")
			.antMatchers("/editcategory").access("hasRole('admin')")
			.antMatchers("/categorytable").access("hasRole('admin')")
			.antMatchers("manage_category_remove").access("hasRole('admin')")
			.antMatchers("manage_category_edit").access("hasRole('admin')")
			
			
			
			.antMatchers("/subcategory").access("hasRole('admin')")
			.antMatchers("/addsubcategory").access("hasRole('admin')")
			.antMatchers("/subcategorytable").access("hasRole('admin')")
			.antMatchers("manage_subcategory_remove").access("hasRole('admin')")
			.antMatchers("manage_subcategory_edit").access("hasRole('admin')")
			
			
			
			.antMatchers("/supplier").access("hasRole('admin')")
			.antMatchers("/addsupplier").access("hasRole('admin')")
			.antMatchers("/suppliertable").access("hasRole('admin')")
			.antMatchers("manage_supplier_remove").access("hasRole('admin')")
			.antMatchers("manage_supplier_edit").access("hasRole('admin')")
			
			
			
			.antMatchers("/product").access("hasRole('admin')")
			.antMatchers("/addproduct").access("hasRole('admin')")
			.antMatchers( "/producttable").access("hasRole('admin')")
			.antMatchers("manage_product_remove").access("hasRole('admin')")
			.antMatchers("manage_product_edit").access("hasRole('admin')")
	
			
			
			.antMatchers("/carttable").access("hasRole('user')")
			.antMatchers("/addToCart").access("hasRole('user')")
			.antMatchers("/manage_cart_remove").access("hasRole('user')")
			.antMatchers("/manage_cart_remove").access("hasRole('user')")
			
			
			.antMatchers("/checkout.xml").access("hasRole('user')")
			
			
			.and()
			  .formLogin().loginPage("/login").failureUrl("/loginError")
			  .usernameParameter("email").passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/logout")
			.and()
			  .exceptionHandling().accessDeniedPage("/accessDenied")
			  .and()
			  .csrf().ignoringAntMatchers("/addcategory", "addsubcategory", "/addsupplier", "/addproduct", "/validate",  "/register");
		}

	 @Bean(name="myAuthenticationManager")
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	     return super.authenticationManagerBean();
	 }
	 
   }

