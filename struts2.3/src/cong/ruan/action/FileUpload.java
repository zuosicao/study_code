package cong.ruan.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport
{
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	
	public File getUpload()
	{
		return upload;
	}
	public void setUpload(File upload)
	{
		this.upload = upload;
	}
	public String getUploadFileName()
	{
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType()
	{
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}
	
	public String execute()
	{
		System.out.println(uploadContentType);
		System.out.println(uploadFileName);
		return "success";
	}
	
}
