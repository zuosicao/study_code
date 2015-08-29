package cong.ruan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import cong.ruan.resposes.Article;
import cong.ruan.resposes.RespTextAndPictureMessage;
import cong.ruan.resposes.RespTextMessage;

/**
 * 消息处理工具类
 * 
 * @author RuanCong
 * @time 2014-4-27 下午12:49:38
 */
public class MessageUtil
{
	// 从微信发过来的文本类型消息
	public static String REQ_MESSAGE_TYPE_TEXT = "text";

	// 从微信发过来的整个类型消息
	public static String REQ_MESSAGE_TYPE_EVENT = "event";
	
	// 菜单click类型
	public static String CLICK_MENU_TYPE = "click";
	
	//订阅事件
	public static String REQ_MESSAGE_TYPE_SUBSCRIBE_EVENT = "subscribe";
	
	//自定义按钮
	public static String CLICK_EVENT = "CLICK";

	// 对所有xml节点的转换都增加CDATA标记
	public static XStream xmlPaser = new XStream(new XppDriver()
	{
		public HierarchicalStreamWriter createWriter(Writer out)
		{
			return new PrettyPrintWriter(out)
			{
				protected void writeText(QuickWriter writer, String text)
				{
					writer.write("<![CDATA[");
					writer.write(text);
					writer.write("]]>");
				};
			};
		};
	});

	/**
	 * 将微信服务器发过来的信息，封装成Map，
	 * 
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> parseXmlMessage(HttpServletRequest req)
			throws IOException
	{
		BufferedReader reader = req.getReader();
		Map<String, String> resultMap = new HashMap<String, String>();
			
		SAXReader saxReader = new SAXReader();
		Document doc;
		try
		{
			doc = saxReader.read(reader);
			@SuppressWarnings("unchecked")
			List<Element> elements = doc.getRootElement().elements();

			for (Element e : elements)
			{
				String elementName = e.getName();
				String elementValue = e.getText();
				resultMap.put(elementName, elementValue);
//				if (elementName.equals("Content"))
//				{
//					String root = req.getSession().getServletContext().getRealPath("/textFile");
//					File f = new File(root,"recievedMessages.txt");
//					FileWriter writer = new FileWriter(f,true);
//					writer.write(elementValue);
//					writer.flush();
//					writer.close();
//				}
			}
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}

		return resultMap;
	}

	/**
	 * 把RespTextMessage转换成xml
	 * 
	 * @param respTextMessage
	 * @return
	 */
	public static String parseRespTextMessageToXml(
			RespTextMessage respTextMessage)
	{
		xmlPaser.alias("xml", respTextMessage.getClass());
		return xmlPaser.toXML(respTextMessage);
	}
	
	/**
	 * 把RespTextAndPictureMessage转换成xml
	 * 
	 * @param message
	 * @return
	 */
	public static String parseTextAndPictureMessageToXml(RespTextAndPictureMessage message)
	{
		xmlPaser.alias("xml",message.getClass());
		xmlPaser.setMode(XStream.NO_REFERENCES);
		xmlPaser.alias("item",Article.class);
		return xmlPaser.toXML(message);
	}

	public static void main(String[] args)
	{
		System.out.println("-----------textMessage---------");
		RespTextMessage respTextMessage = new RespTextMessage();
		respTextMessage.setFromUserName("toUserName");
		respTextMessage.setToUserName("fromUserName");
		respTextMessage.setMsgType("text");
		respTextMessage.setCreateTime(new Date().getTime());
		respTextMessage.setContent("您发送的信息是1！暂时无效");
		System.out.println(parseRespTextMessageToXml(respTextMessage));
		System.out.println("-----------end textMessage---------");
	}
}
