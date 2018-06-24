package com.canteen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NamingContextExtPackage.URLStringHelper;

import com.canteen.pojo.Admin;

public class AdminFilter implements Filter
{
	
	@Override
	public void destroy()
	{
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null)
		{
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/SSH-Canteen/admin/login/login.jsp");
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}
	
}
