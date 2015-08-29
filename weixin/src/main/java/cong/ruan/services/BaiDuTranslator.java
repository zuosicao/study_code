package cong.ruan.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 调用百度翻译API
 * 
 * @author RuanCong
 * @time 2014-5-1 下午9:04:32
 */
public class BaiDuTranslator
{
	public static String BAIDU_TRANSLATE_URL;
	public static String BAIDU_APPID;

	static
	{
		Properties pros = new Properties();
		try
		{
			pros.load(BaiDuTranslator.class.getClassLoader()
					.getResourceAsStream("weixin.properties"));
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
		BAIDU_TRANSLATE_URL = pros.getProperty("BAIDU_TRANSLATE_URL");
		BAIDU_APPID = pros.getProperty("BAIDU_APPID");
	}
	
	/**
	 * 利用百度API 翻译
	 * @param from
	 * @param to
	 * @param src 要翻译的内容
	 * @return
	 */
	//{"from":"en","to":"zh","trans_result":[{"src":"today","dst":"\u4eca\u5929"}]}
	//http://openapi.baidu.com/public/2.0/bmt/translate?client_id=YourApiKey&q=today&from=auto&to=auto
	public static String translate(String from,String to,String src)
	{
		src = encoderWithUTF8(src);
		String thePath = BAIDU_TRANSLATE_URL + "?client_id=" + BAIDU_APPID+"&q=" + src + "&from=" + from + "&to=" + to;
		System.out.println(thePath);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(thePath);
		String resultJson = null;//返回来的json结果
		StringBuilder builder = new StringBuilder();//储存翻译结果
		
		try
		{
			HttpResponse response = httpClient.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				HttpEntity entity = response.getEntity();
				resultJson = EntityUtils.toString(entity);
				JSONObject jsonObject = JSONObject.fromObject(resultJson);
				Object errorCode = jsonObject.get("error_code");
				if (errorCode == null)//没有发生错误
				{
					JSONArray array = jsonObject.getJSONArray("trans_result");
					for (int i = 0; i < array.size(); i++)
					{
						JSONObject o = (JSONObject)array.get(i);
						builder.append(o.getString("dst"));
					}
				}else
				{
					builder.append("errorCode:" + errorCode + "\n系统发生错误！");
				}
			}
		} catch (ClientProtocolException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return builder.toString();
	}
	
	public static String encoderWithUTF8(String src)
	{
		String result = "";
		try
		{
			result = URLEncoder.encode(src,"utf-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 中文翻译成英文
	 * @param src
	 * @return
	 */
	public static String translateZhToEn(String src)
	{
		return translate("zh","en",src);
	}
	
	/**
	 * 英文翻译成中文
	 * @param src
	 * @return
	 */
	public static String translateEnToZh(String src)
	{
		return translate("en","zh",src);
	}
	
	public static void main(String[] args)
	{
		System.out.println(translate("en","zh","hello ,what's you name\n I don't know"));
	}
}
