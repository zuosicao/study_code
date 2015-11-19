package cong.ruan.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cong.ruan.beanobj.StudentObj;
import cong.ruan.services.StudentService;

@Controller
public class StudentController {

	@Resource
	private StudentService stuService;

	@RequestMapping("student")
	public @ResponseBody StudentObj getStudent(String name) {
		StudentObj stuObj = stuService.getOneStudentByName(name);
		return stuObj;
	}
	
	@RequestMapping("pageStu")
	public @ResponseBody StudentObj pageStudent(Integer page,Integer pageSize) {
		StudentObj stuObj = stuService.getPageStudent(page, pageSize);
		return stuObj;
	}
	
	@RequestMapping("allStu")
	public @ResponseBody List<StudentObj> allStudent() {
		List<StudentObj> stuObjs = stuService.getAllStudents();
		return stuObjs;
	}
	
	@RequestMapping("testEntity")
	public void testPostEntity(HttpServletRequest request){
		try {
			BufferedReader  rd = request.getReader();
			String line = rd.readLine();
			while (line != null){
				System.out.println(line);
				line = rd.readLine();
			}
			
			InputStream is = request.getInputStream();
			String tt = request.getParameter("tt");
			System.out.println(tt);
			byte[] temp = new byte[1024] ;
			int length = -1;
			StringBuffer sb = new StringBuffer();
			while ((length = is.read(temp)) != -1){
				sb.append(new String(temp,0,length));
			}
			String str = sb.toString();
			System.out.println(str + ">》");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
