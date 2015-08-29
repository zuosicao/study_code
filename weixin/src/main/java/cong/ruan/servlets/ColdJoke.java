package cong.ruan.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cong.ruan.common.pojos.Joke;
import cong.ruan.services.CaputerJoke;
import cong.ruan.utils.CommonUtil;

public class ColdJoke extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5147306232010158795L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String pageNum = request.getParameter("pageNum");    //新闻  具体内容所在的序号
		int currPage = CommonUtil.parseCurrPage(pageNum); //当前所在页面
		List<Joke> jokes = CaputerJoke.getHotJokes(pageNum);
		request.setAttribute("jokes",jokes);
		request.setAttribute("currPage",currPage);
		request.getRequestDispatcher("hotJokes.jsp").forward(request,response);
		
	}

}
