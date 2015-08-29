package cong.ruan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

public class DownLoad
{
	private InputStream targetFile;
	private String fileName;
	
	public InputStream getTargetFile()
	{
		return targetFile;
	}
	public void setTargetFile(InputStream targetFile)
	{
		this.targetFile = targetFile;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	public String execute()
	{
		String rootPath = ServletActionContext.getServletContext().getRealPath("/files");
		fileName = "disAllowed.jpg";
		try
		{
			targetFile = new FileInputStream(new File(rootPath,fileName));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return "success";
	}
}
