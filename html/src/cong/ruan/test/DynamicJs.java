package cong.ruan.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicJs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fun1 = "function(){alert ('fun1');}";
		String fun2 = "function(){alert ('fun2');}";

		request.setAttribute("fun1", fun1);
		request.setAttribute("fun2", fun2);
		
		request.getRequestDispatcher("dynamicJs.jsp").forward(request, response);
	}

}
