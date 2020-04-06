package com.spring.security.login.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.security.login.jdbc.model.Customer;


@Controller
public class RegistrationController 
{
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model)
	{
		Customer customer = new Customer();
		
		model.addAttribute("cust", customer);
		
		return "Registration-Page";
	}
	
	
	@PostMapping("/registerNewCustomer")
	public String registerForm(@ModelAttribute("cust") Customer customer, BindingResult bindResult , Model model)
	{
		String username = customer.getUsername();
		
		model.addAttribute("username", "This Is Username Of Customer : " +username);
		
		
		String encodedPassword = passwordEncoder.encode(customer.getPassword());
		
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		System.out.println(" \n ENCODED PASSWORD USING BCRYPT IS : " +encodedPassword);
		
		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		
		User user = new User(username, encodedPassword, authorities);
		
		
		userDetailsManager.createUser(user);
		
		
		return "Registration-Page";
	}

}
