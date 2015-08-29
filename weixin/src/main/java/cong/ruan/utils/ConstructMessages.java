package cong.ruan.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import cong.ruan.common.pojos.HistoryNews;
import cong.ruan.resposes.Article;
import cong.ruan.resposes.RespTextAndPictureMessage;
import cong.ruan.resposes.RespTextMessage;
import cong.ruan.services.CaputerTodayOfHistory;

/**
 * 负责构造各种类型的消息
 * @author RuanCong
 * @time 2014-4-27 下午1:53:32
 */
public class ConstructMessages
{
	public static String APP_URL;
	public static String HNUST_MOBILE_URL;
	
	static
	{
		Properties pros = new Properties();
		try
		{
			pros.load(ConstructMessages.class.getClassLoader().getResourceAsStream("weixin.properties"));
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
		APP_URL = pros.getProperty("APP_URL");
		HNUST_MOBILE_URL = pros.getProperty("HNUST_MOBILE_URL");
	}
	
	/**
	 * 构造发送给用户的文本信息
	 * @param toUserName 信息发送的目标用户 （用户Id）
	 * @param fromUserName 信息从哪里发出去的（公众号）
	 * @param content 要回复的文本内容 
	 * @return
	 */
	public static RespTextMessage constructRespTextMessage(String toUserName,String fromUserName,String content)
	{
		RespTextMessage respTextMessage = new RespTextMessage();
		respTextMessage.setFromUserName(fromUserName);
		respTextMessage.setToUserName(toUserName);
		respTextMessage.setMsgType("text");
		respTextMessage.setCreateTime(new Date().getTime());
		respTextMessage.setContent(content);
		return respTextMessage;
	}
	
	/**
	 * 构造某一天的  历史事件 的图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @param month
	 * @param day
	 * @return
	 */
	public static RespTextAndPictureMessage constructHistoryMessage(String toUserName,String fromUserName,int month,int day)
	{
		
		List<HistoryNews> listNews = CaputerTodayOfHistory.getHistoryNews(month,day);
		List<Article> list = new ArrayList<Article>();
		
		for (int i = 0; i < listNews.size(); i ++)
		{
			Article artical = new Article(listNews.get(i).getNewsTitle(),listNews.get(i).getNewsTitle(),ConstructMessages.APP_URL + "images/" + (i+1) + ".png",ConstructMessages.APP_URL+"concreteEvent?newsNum=" + listNews.get(i).getNewsNumber());
			list.add(artical);
		}
		RespTextAndPictureMessage textAndPictureMessage = new RespTextAndPictureMessage(toUserName,fromUserName,new Date().getTime(),RespTextAndPictureMessage.MESSAGE_TYPE,list.size(),list);
		return textAndPictureMessage;
	}
	
	/**
	 * 当时间缺省时，默认构造当天的  历史事件 的图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @param month
	 * @param day
	 * @return
	 */
	public static RespTextAndPictureMessage constructHistoryMessage(String toUserName,String fromUserName)
	{
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		return constructHistoryMessage(toUserName,fromUserName,month,day);
	}
	
	/**
	 * 构造冷笑话图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static RespTextAndPictureMessage constructColdJokeMessage(String toUserName,String fromUserName)
	{
		Article art = new Article("轻松笑一笑","说明：所有数据来处“我们爱讲冷笑话”",ConstructMessages.APP_URL+"images/coldJoke.jpg",ConstructMessages.APP_URL+"coldJoke?pageNum=1");
		List<Article> list = new ArrayList<Article>();
		list.add(art);
		RespTextAndPictureMessage textAndPictureMessage = new RespTextAndPictureMessage(toUserName,fromUserName,new Date().getTime(),RespTextAndPictureMessage.MESSAGE_TYPE,list.size(),list);
		return textAndPictureMessage;
	}
	
	/**
	 * 构造掌上湖科的首页
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static RespTextAndPictureMessage constructHnustMobile(String toUserName,String fromUserName)
	{
		Article art = new Article("掌上湖科","湖南科技大学信息平台",ConstructMessages.HNUST_MOBILE_URL+"images/hnust_index.jpg",ConstructMessages.HNUST_MOBILE_URL);
		List<Article> list = new ArrayList<Article>();
		list.add(art);
		RespTextAndPictureMessage textAndPictureMessage = new RespTextAndPictureMessage(toUserName,fromUserName,new Date().getTime(),RespTextAndPictureMessage.MESSAGE_TYPE,list.size(),list);
		return textAndPictureMessage;
	}
	
	
	/**
	 * 超皮哥的页面 
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static RespTextAndPictureMessage constructChao(String toUserName,String fromUserName)
	{
		Article art = new Article("超你大爷","超大大",ConstructMessages.HNUST_MOBILE_URL+"images/hnust_index.jpg","http://123.57.86.201/ruancong/chao/scan.html");
		List<Article> list = new ArrayList<Article>();
		list.add(art);
		RespTextAndPictureMessage textAndPictureMessage = new RespTextAndPictureMessage(toUserName,fromUserName,new Date().getTime(),RespTextAndPictureMessage.MESSAGE_TYPE,list.size(),list);
		return textAndPictureMessage;
	}
	
	public static void main(String[] args)
	{
		//RespTextAndPictureMessage m = constructHistoryMessage("d","d");
		//System.out.println(m.getArticleCount());
	}
}
