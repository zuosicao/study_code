package cong.ruan.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cong.ruan.common.pojos.Joke;

/**
 * 获取次笑话数据 ，从www.lengxiaohua.com上抓取
 * 
 * @author RuanCong
 * @time 2014-5-1 上午11:14:51
 */
public class CaputerJoke
{
	private static String JOKE_URL = "http://m.lengxiaohua.com/";// 获取数据的url
	private static int DEFAULT_PAGE_NUMBER = 1;// 默认的第几页
	private static int DEFAULT_PAGE_SIZE = 20;// 默认每页几条

	/**
	 * 获取指定数量的热门笑话
	 * 
	 * @param number
	 *            获取笑话的条数
	 * @return
	 */
	public static List<Joke> getHotJokes(int number, int pageNum)
	{
		List<Joke> jokesList = new ArrayList<Joke>();
		CloseableHttpClient client = HttpClients.createDefault();
		String thePath = JOKE_URL + "?page_num=" + pageNum;
		HttpResponse response = null;
		InputStream in = null;
		HttpEntity entity = null;

		try
		{
			HttpGet get = new HttpGet(thePath);
			response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				entity = response.getEntity();
				in = entity.getContent();
			}

			// Document doc = Jsoup.connect(thePath).get(); //偶尔连接失败
			Document doc = Jsoup.parse(in, "utf-8", thePath);
			Elements elements = doc.select("div[class=w1 bd2]");
			for (int i = 0; i < number && i < elements.size(); i++)
			{
				Element div = elements.get(i);
				Element jokeContentBox = div.child(1);
				String jokeContent = jokeContentBox.text();
				Elements jokeImg = jokeContentBox.select("img");
				String imgUrl = null;

				if (jokeImg.size() != 0)
				{
					imgUrl = jokeImg.get(0).attr("abs:src");
					imgUrl = caputerImageName(imgUrl);
					//fdsdfsa.jpg!water
					//System.out.println(imgUrl + "--->>>from CaputerJoke.java");
				}

				Joke aJoke = new Joke();
				aJoke.setContent(jokeContent);
				aJoke.setImgUrl(imgUrl);

				jokesList.add(aJoke);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			try
			{
				EntityUtils.consume(entity);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jokesList;
	}

	/**
	 * 
	 * @return
	 */
	public static List<Joke> getHotJokes()
	{
		return getHotJokes(DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
	}

	/**
	 * 
	 * @return
	 */
	public static List<Joke> getHotJokes(String pageNum)
	{
		int theNum = DEFAULT_PAGE_NUMBER;
		if (pageNum != null)
		{

			try
			{
				if (Integer.parseInt(pageNum) > 0)
				{
					theNum = Integer.parseInt(pageNum);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return getHotJokes(DEFAULT_PAGE_SIZE, theNum);
	}

	private static String caputerImageName(String imageName)
	{
		Pattern p = Pattern.compile(".+\\.(jpg|png|gif)");
		Matcher m = p.matcher(imageName);
		m.find();
		
		return m.group();
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(getHotJokes().get(1).getContent());
	}
}
