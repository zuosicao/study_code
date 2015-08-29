package cong.ruan.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cong.ruan.common.pojos.ContentNews;
import cong.ruan.common.pojos.HistoryNews;

public class CaputerTodayOfHistory
{
	private static String INDEX_URL = "http://www.rijiben.com";//获取数据的url
	private static String SPECIFIC_CONTENT_URL = "http://www.rijiben.com/news";//具体新闻内容url
	
	/**
	 * 获取历史上的今天发生的事件
	 * @param theMonth 
	 * @param theDay
	 * @return
	 */
	public static List<HistoryNews> getHistoryNews(int theMonth,int theDay)
	{
		String thePath = INDEX_URL + "/" + theMonth + "/" + theDay;
		List<HistoryNews> resultList = new ArrayList<HistoryNews>();

		try
		{
			Document doc = Jsoup.connect(thePath).get();
			Elements elements = doc.select(".listren ul a");
			for (int i = 0; i < 9 && i < elements.size(); i++)
			{
				Element a = elements.get(i);
				String url = a.attr("abs:href");
				String newsNumber = url.replaceAll("[^\\d]","");
				String title = a.text();
				resultList.add(new HistoryNews(title,newsNumber));
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return resultList;
	}
	
	/**
	 * 获取具体的新闻内容
	 * @param newsNumber 新闻序号
	 */
	public static ContentNews getSpecificNewsContent(String  newsNumber)
	{
		String thePath = SPECIFIC_CONTENT_URL + newsNumber+ "/";
		ContentNews contentNews = new ContentNews();
		
		try
		{
				
			Document doc = Jsoup.connect(thePath).get();
			Element titleElement = doc.select(".showbiao").first();
			String newsTitle = titleElement.text();
			Element contentElement = titleElement.nextElementSibling();
			String result = contentElement.text();
			result = result.replaceAll(" +"," ");//根据空格换行
			String[] strs = result.split(" ");
			List<String> newsContent = new ArrayList<String>();
			Collections.addAll(newsContent,strs);
			
			contentNews.setNewsTitle(newsTitle);
			contentNews.setContents(newsContent);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return contentNews;
	}
	
	public static void main(String[] args)
	{
		//System.out.println(getHistoryNews(4,29).get(2).getNewsTitle());
//		List<String> list = getSpecificNewsContent("2894").getContents();
//		for (String str : list)
//		{
//			System.out.println(str);
//		}
//		System.out.println( getSpecificNewsContent("2894").getNewsTitle());
	
		List<HistoryNews> news = getHistoryNews(7, 29);
		System.out.println(news.get(1).getNewsNumber());
	
	}
}
