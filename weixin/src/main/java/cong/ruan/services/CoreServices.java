package cong.ruan.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cong.ruan.resposes.Article;
import cong.ruan.resposes.RespTextAndPictureMessage;
import cong.ruan.resposes.RespTextMessage;
import cong.ruan.utils.ConstructMessages;
import cong.ruan.utils.MenuKeys;
import cong.ruan.utils.MessageUtil;
import cong.ruan.utils.ServiceConstants;

/**
 * 核心服务类，处理各类从微信发过来的消息
 * @author RuanCong
 * @time 2014-4-27 上午11:26:42
 */
public class CoreServices
{
	/**
	 * 处理微信发过来的请求，然后返回相应的回复消息
	 * @param request
	 * @return 
	 * @throws IOException 
	 */
	public static String processRequest(HttpServletRequest req) throws IOException
	{
		Map<String,String> messageMap = MessageUtil.parseXmlMessage(req);
		
		//得用户发过来的消息类型
		String mesType = messageMap.get("MsgType");
		
		String toUserName = messageMap.get("FromUserName"); // 回复消息将要发送的目标用户 （用户Id）
		String fromUserName = messageMap.get("ToUserName");	//fromUserName 信息从哪里发出去的（公众号）
		
		String responseMessages = "";//将要回复的  xml格式的消息
		
		//用户发过来的文本消息
		if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(mesType))
		{
			String content = messageMap.get("Content").trim().toLowerCase();//得到用户发过来的信息内容，再回复相应的消息
			
			if (ServiceConstants.NEWS.equals(content))
			{
				Article art = new Article("新浪NBA","新浪NBA,这里是描述",ConstructMessages.APP_URL+"images/haha.jpg","http://nba.sina.cn/?ttp=navnba");
				Article art2 = new Article("ZAKER科技新闻","ZAKER科技新闻",ConstructMessages.APP_URL+"images/tech.png","http://app.myzaker.com/news/app.php?app_id=13");
				Article art3 = new Article("头条","新闻1description3",ConstructMessages.APP_URL+"images/headNews.png","http://m.toutiao.com/?hideAll=1&utm_source=ucplus_toutiao");
				List<Article> list = new ArrayList<Article>();
				list.add(art);
				list.add(art2);
				list.add(art3);
				RespTextAndPictureMessage textAndPictureMessage = new RespTextAndPictureMessage(toUserName,fromUserName,new Date().getTime(),"news",list.size(),list);
				responseMessages = MessageUtil.parseTextAndPictureMessageToXml(textAndPictureMessage);
			}else if(ServiceConstants.HISTORY_NEWS.equals(content))
			{
				RespTextAndPictureMessage textAndPictureMessage =ConstructMessages.constructHistoryMessage(toUserName,fromUserName);
				if( textAndPictureMessage.getArticleCount() != 0)
				{
					responseMessages = MessageUtil.parseTextAndPictureMessageToXml(textAndPictureMessage);
				}
				else
				{
					RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,"sorry,暂无数据");
					responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
				}
			}else if(ServiceConstants.COLD_JOKE.equals(content))
			{
				RespTextAndPictureMessage textAndPictureMessage =ConstructMessages.constructColdJokeMessage(toUserName,fromUserName);
				responseMessages = MessageUtil.parseTextAndPictureMessageToXml(textAndPictureMessage);
			}
			else if(ServiceConstants.TRANSLATE.equals(content))
			{
				StringBuilder builder = new StringBuilder();
				builder.append("翻译规则如下：\n")
				   .append("中译英：41+要翻译的内容\n")
				   .append("英译中：42+要翻译的内容\n")
				   .append("例如：想翻译Hello,发送如下内容即可\n")
				   .append("42Hello");
				RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,builder.toString());
				responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
			}
			else if (ServiceConstants.HNUST_MOBILE.equals(content))
			{
				RespTextAndPictureMessage textAndPictureMessage =ConstructMessages.constructHnustMobile(toUserName,fromUserName);
				responseMessages = MessageUtil.parseTextAndPictureMessageToXml(textAndPictureMessage);
			}
			else if(content.startsWith("41"))//中文翻译成英文
			{
				String src = content.replaceAll("41","");
				String translateResult = BaiDuTranslator.translateZhToEn(src);
				RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,translateResult);
				responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
			}
			else if(content.startsWith("42"))//英文翻译成中文
			{
				String src = content.replaceAll("42","");
				String translateResult = BaiDuTranslator.translateEnToZh(src);
				RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,translateResult);
				responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
			}else if(content.equals("chao"))//测试超皮哥的页面 
			{
				RespTextAndPictureMessage textAndPictureMessage =ConstructMessages.constructChao(toUserName,fromUserName);
				responseMessages = MessageUtil.parseTextAndPictureMessageToXml(textAndPictureMessage);
			}
			else
			{
				StringBuilder builder = new StringBuilder();
				builder.append("/:coffee/:coffee\n")
				   .append("回复以下代码获取信息:\n")
				   .append(ServiceConstants.COLD_JOKE + "   冷笑话\n")
				   .append(ServiceConstants.NEWS + "   获取新闻\n")
				   .append(ServiceConstants.HISTORY_NEWS + "   历史上的今天\n")
				   .append(ServiceConstants.TRANSLATE + "   中英文互译\n")
				   .append(ServiceConstants.HNUST_MOBILE + "  掌上湖科首页\n")
				   .append("/:coffee/:coffee");
				RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,builder.toString());
				responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
			}
			
		}
		//事件消息
		else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(mesType))
		{
			String eventType = messageMap.get("Event");
			
			//用户订阅事件
			if(MessageUtil.REQ_MESSAGE_TYPE_SUBSCRIBE_EVENT.equals(eventType))
			{
				StringBuilder builder = new StringBuilder();
				builder.append("/:coffee/:coffee\n")
					   .append("回复以下代码获取信息:\n")
					   .append(ServiceConstants.COLD_JOKE + "   冷笑话\n")
					   .append(ServiceConstants.NEWS + "   获取新闻\n")
					   .append(ServiceConstants.HISTORY_NEWS + "   历史上的今天\n")
					   .append(ServiceConstants.TRANSLATE + "   中英文互译\n")
					   .append(ServiceConstants.HNUST_MOBILE + "  掌上湖科首页\n")
					   .append("/:coffee/:coffee");
				RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,builder.toString());
				responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
			}
			//自定义菜单点击事件
			else if (MessageUtil.CLICK_EVENT.equals(eventType))
			{
				String eventKey = messageMap.get("EventKey");
				if (MenuKeys.MOBILE.equals(eventKey))
				{
					RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,"/:coffee/:coffee\n建议您换个新手机\n/:coffee/:coffee");
					responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
				}
				else if(MenuKeys.COMPUTER.equals(eventKey))
				{
					RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,"/:coffee/:coffee\n建议您换个新电脑\n/:coffee/:coffee");
					responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
				}
				else if(MenuKeys.BASKEYBALL.equals(eventKey))
				{
					RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,"/:coffee/:coffee\n建议您打打篮球\n/:coffee/:coffee");
					responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
				}
				else if(MenuKeys.FOOTBALL.equals(eventKey))
				{
					RespTextMessage respTextMessage = ConstructMessages.constructRespTextMessage(toUserName,fromUserName,"/:coffee/:coffee\n建议您路踢踢足球\n/:coffee/:coffee");
					responseMessages = MessageUtil.parseRespTextMessageToXml(respTextMessage);
				}
			}
		}
		
		return responseMessages;
	}
}
