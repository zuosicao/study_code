package cong.ruan.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import cong.ruan.common.pojos.AccessToken;
import cong.ruan.common.pojos.Menu;
import net.sf.json.JSONObject;

public class CommonUtil
{
	private static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	private static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

	/**
	 * 获取access token
	 * 
	 * @return
	 */
	public static AccessToken getAccessToken()
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		Properties pros = new Properties();
		try
		{
			pros.load(AccessToken.class.getClassLoader().getResourceAsStream(
					"weixin.properties"));
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
		String appId = pros.getProperty("APP_ID");
		String appSecret = pros.getProperty("APP_SECRET");
		String theTargetUrl = TOKEN_URL + "&appid=" + appId + "&secret="
				+ appSecret;
		HttpGet get = new HttpGet(theTargetUrl);
		HttpResponse response = null;
		String result = "";
		try
		{
			response = httpClient.execute(get);
			HttpEntity resultEntity = response.getEntity();
			result = EntityUtils.toString(resultEntity);
			return parseJson(result);
		} catch (IOException e1)
		{
			System.out.println("errorCode:" + result);
			e1.printStackTrace();
		} finally
		{
			colseHttpClientConnection(httpClient);
		}
		return null;
	}

	/**
	 * 
	 * @param accessTokenJson
	 * @return
	 */
	// accessTokenJson
	// 的格式如下：{'access_token':'BmP7uifzbu1S3757gxKd0ZYCFJJ13SogDChwfSp-NWnGIfQYpodjZVETH9Grk4lX','expires_in':7200}
	private static AccessToken parseJson(String accessTokenJson)
	{
		XStream xStream = new XStream(new JettisonMappedXmlDriver());
		xStream.setMode(XStream.NO_REFERENCES);
		accessTokenJson = "{xml:" + accessTokenJson + "}";
		xStream.alias("xml", AccessToken.class);
		xStream.aliasField("access_token", AccessToken.class, "accessToken");
		xStream.aliasField("expires_in", AccessToken.class, "expiresIn");
		return (AccessToken) xStream.fromXML(accessTokenJson);
	}

	public static boolean createMenu(Menu menu, String accessToken)
	{
		boolean createResult = false;
		Gson gson = new Gson();
		String menuJson = gson.toJson(menu);

		String createMenuUrl = CREATE_MENU_URL + "?access_token=" + accessToken;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = null;
		HttpPost post = new HttpPost(createMenuUrl);
		String resultJson = "";

		post.setEntity(new StringEntity(menuJson, "utf-8"));
		try
		{
			response = httpClient.execute(post);
			System.out.println(response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();
			resultJson = EntityUtils.toString(entity);

			JSONObject jsonObject = JSONObject.fromObject(resultJson);

			if (0 == jsonObject.getInt("errcode"))// 创建成功时返回{"errcode":0,"errmsg":"ok"}
			{
				createResult = true;
			} else
			{
				System.out.println(resultJson);
			}
		} catch (ClientProtocolException e)
		{
			e.printStackTrace();
			System.out.println(resultJson);
		} catch (IOException e)
		{
			System.out.println(resultJson);
			e.printStackTrace();
		} finally
		{
			colseHttpClientConnection(httpClient);
		}
		return createResult;
	}

	public static void colseHttpClientConnection(CloseableHttpClient httpClient)
	{
		if (httpClient != null)
		{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将字符串形式的页面转化为数，转化失败则返回1;
	 * 
	 * @param pageNum
	 * @return
	 */
	public static int parseCurrPage(String pageNum)
	{

		int currPage = 1;
		if (pageNum != null)
		{
			try
			{
				currPage = Integer.parseInt(pageNum);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return currPage;
	}

	public static void main(String[] args)
	{
		// String json =
		// "{'access_token':'BmP7uifzbu1S3757gxKd0ZYCFJJ13SogDChwfSp-NWnGIfQYpodjZVETH9Grk4lX','expires_in':7200}";
		// AccessToken token = parseJson(json);
		// System.out.println(token.getAccessToken());
		// System.out.println(token.getExpiresIn());
		AccessToken token = getAccessToken();
		System.out.println(token.getAccessToken());
	}
}
