package cong.ruan.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cong.ruan.beanobj.FileUploadObj;
import cong.ruan.beans.Student;
import cong.ruan.utils.RandomUtil;

@Controller("fileupLoad")
@RequestMapping("/fileupLoad")
public class FileUpload {
	
	/**
	 * 保存上传附件的文件夹
	 */
	private static String ULOPAD_FOLDER = "uploads";
	
	@RequestMapping(method=RequestMethod.POST,value="handle")
	public @ResponseBody FileUploadObj handleFileUpload(@RequestParam(value="file",required=true)MultipartFile file,HttpServletRequest request)
	{
		FileUploadObj result = new FileUploadObj();
		try {
			String rootPath = request.getServletContext().getRealPath("/");
			System.out.println(">>文件上传了！！"+rootPath);
			File folder = new File(rootPath+ULOPAD_FOLDER);
			if (!folder.exists()){//如果目录不存在就创建
				folder.mkdir();
			}
			String uploadFileName = file.getOriginalFilename();//原文件名
			String suffix =  uploadFileName.substring(uploadFileName.lastIndexOf(".")) ;//文件后缀
			String finalFileName = RandomUtil.randomFileName() + suffix;//最终文件名
			file.transferTo(new File(folder,finalFileName));
			String savedPath = ULOPAD_FOLDER + "/"+ finalFileName;
			result.setUrl(savedPath);
			result.handleSuccess();
		} catch (Exception e) {
			result.handleException(e);
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value="/test",produces = "application/json; charset=utf-8")//produces 解决中文乱码
	public @ResponseBody String test()
	{
		return "字符串中文";
	}
}
