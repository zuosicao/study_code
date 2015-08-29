package cong.ruan.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cong.ruan.services.CoreServices;
import cong.ruan.utils.SignUtil;

public class TheCoreController extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4902394052437075480L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//TextMessage textMessage = HandleMessageServices.handleMessageFromUser(req);
	
		//HandleMessageServices.sendMessageToUser(resp,textMessage);
		String responseMessage = CoreServices.processRequest(req);
//		String root = req.getSession().getServletContext().getRealPath("/textFile");
//		FileWriter fileWriter = new FileWriter(new File(root,"messages.txt"),true);
//		fileWriter.write(responseMessage + "\n");
//		fileWriter.flush();
//		fileWriter.close();
		PrintWriter writer = resp.getWriter();
		writer.write(responseMessage);
		writer.flush();
		writer.close();
	}
}
