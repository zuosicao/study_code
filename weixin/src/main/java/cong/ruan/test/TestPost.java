package cong.ruan.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cong.ruan.utils.CommonUtil;

public class TestPost
{
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost/ruancong/theCoreController");
		post.setEntity(new StringEntity("<xml><ToUserName><![CDATA[toUser]]></ToUserName>\n" +
				"<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
				" <CreateTime>1348831860</CreateTime>\n" +
				"<MsgType><![CDATA[text]]></MsgType>\n" +
				" <Content><![CDATA[2]]></Content><MsgId>1234567890123456</MsgId></xml>","utf-8"));
		HttpResponse re = client.execute(post);

		//		HttpGet get = new HttpGet("https://www.google.com.hk/search?q=%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E6%96%87%E6%A1%A3&oq=%E5%BE%AE%E4%BF%A1&aqs=chrome.3.69i57j0j69i59l2j69i65l2.15106j0j1&sourceid=chrome&es_sm=93&ie=UTF-8");
//		CloseableHttpResponse re = client.execute(get);
	System.out.println(EntityUtils.toString(re.getEntity(),"utf-8"));
	CommonUtil.colseHttpClientConnection(client);
	System.out.println("end!!");
		
	}
}
