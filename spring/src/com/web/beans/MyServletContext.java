package com.web.beans;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class MyServletContext implements ServletContextAware {

	private String webRoot;
	private ServletContext servletContext;
	
	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = this.servletContext.getContextPath();
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public ServletContext getServletContext()
	{
		return servletContext;
	}

}
