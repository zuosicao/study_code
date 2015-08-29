package cong.ruan.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cong.ruan.common.pojos.ContentNews;
import cong.ruan.services.CaputerTodayOfHistory;

public class ConcreteHistoryEvent extends HttpServlet
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5569419935630456493L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String newsNum = request.getParameter("newsNum");    //新闻  具体内容所在的序号
		ContentNews contentNews = CaputerTodayOfHistory.getSpecificNewsContent(newsNum);
		request.setAttribute("newsContent",contentNews.getContents());
		request.setAttribute("title",contentNews.getNewsTitle());
		request.getRequestDispatcher("concreteHistoryEvents.jsp").forward(request,response);
	}

}
