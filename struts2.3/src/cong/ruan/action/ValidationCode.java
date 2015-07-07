package cong.ruan.action;

import java.io.InputStream;
import java.util.Map;

import cong.ruan.untils.ImageUntil;


/**
 * 获取验证码
 * @author RuanCong
 * @time 2014-5-4 下午8:37:13
 */
public class ValidationCode
{
	private InputStream codeStream;

	public InputStream getCodeStream()
	{
		return codeStream;
	}

	public void setCodeStream(InputStream codeStream)
	{
		this.codeStream = codeStream;
	}
	
	public String execute()
	{
		Map<String,InputStream> imageMap = ImageUntil.createImage();
		String validationCode = imageMap.keySet().iterator().next();
		codeStream = imageMap.get(validationCode);
		return "success";
	}
	
}
