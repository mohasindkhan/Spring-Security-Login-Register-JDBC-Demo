package com.spring.security.login.jdbc.model;

public class Customer 
{
	
	private String username;
	private String password;
	
	
	public Customer()
	{
		
	}

	
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

}
