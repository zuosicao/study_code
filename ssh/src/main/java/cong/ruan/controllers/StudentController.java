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

import cong.ruan.beanobj.BaseObj;
import cong.ruan.beanobj.StudentObj;
import cong.ruan.services.StudentService;
import cong.ruan.utils.Pager;

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
	public @ResponseBody BaseObj pageStudent(Integer page,Integer pageSize) {
		BaseObj stuObj = stuService.getPageStudent(page, pageSize);
		return stuObj;
	}
	
	@RequestMapping("buiPage")
	public @ResponseBody BaseObj buiPageStudent(int limit,int pageIndex) {
		StudentObj stuObj = new StudentObj();
		try{
			Pager<StudentObj> aPager = stuService.pagerStudent(pageIndex+1, limit);//pageIndex 从0开始
			stuObj.setHasError(false);
			stuObj.setResults(aPager.getTotal());
			System.out.println(aPager.getTotal());
			stuObj.setRows(aPager.getDatas());
		}catch(Exception ex){
			stuObj.setHasError(true);
			stuObj.setError("发生异常");
			ex.printStackTrace();
		}
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
	
	@RequestMapping("home")
	public String home(){
		System.out.println("home>>>>>>>>");
		return "home";
	}

}
