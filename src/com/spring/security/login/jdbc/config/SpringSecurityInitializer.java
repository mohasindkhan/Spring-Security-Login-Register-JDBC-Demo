package com.spring.security.login.jdbc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringSecurityInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] { SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}

}
