//package cong.ruan.test;
//
//import java.io.Writer;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
//import com.thoughtworks.xstream.io.json.JsonWriter;
//
//import cong.ruan.beans.TextMessage;
//
//public class TestJsonByXStream
//{
//	public static void main(String[] args)
//	{
//		//TextMessage text = new TextMessage("to", "from", "11111", "text","content", "111122");
//		//没有头
//		XStream xStream = new XStream(new JettisonMappedXmlDriver()
//		{
//			@Override
//			public HierarchicalStreamWriter createWriter(Writer writer)
//			{
//				return new JsonWriter(writer,JsonWriter.DROP_ROOT_MODE);
//			}
//		});
//		xStream.setMode(XStream.NO_REFERENCES);
//		//xStream.alias("xml",TextMessage.class);
//		String jsonResult = xStream.toXML(text);
//		System.out.println(jsonResult);
//		//System.out.println("-----------------------------");
//		String jsonString = "{'toUserName': 'to', 'fromUserName': 'from', 'createTime': '11111','msgType': 'text','content': 'content','msgId': '111122'}";
//		XStream xJson = new XStream(new JettisonMappedXmlDriver());
//		//xJson.alias("xml",TextMessage.class);
//		jsonString = "{'xml':" + jsonString + "}";
//		TextMessage mess = (TextMessage)xJson.fromXML(jsonString);
//		System.out.println(mess.getFromUserName());
//		System.out.println(mess.getContent());
//		
//		System.out.println("-----------xml TestBean--------------");
//		TestBean testBean = new TestBean();
//		testBean.setAge(22);
//		testBean.setName("username");
//		XStream xx = new XStream();
//		xx.alias("User",TestBean.class);
//		String testUserString = xx.toXML(testBean);
//		System.out.println(testUserString);
//		TestBean b = (TestBean)xx.fromXML(testUserString);
//		System.out.println(b.getAge());
//		System.out.println("-----------end xml TestBean--------------");
//		
//		System.out.println("-----------json TestBean--------------");
//		TestBean testBean2 = new TestBean();
//		testBean2.setAge(222);
//		testBean2.setName("username2");
//		XStream xxjson = new XStream(new JettisonMappedXmlDriver()
//		{
//			@Override
//			public HierarchicalStreamWriter createWriter(Writer writer)
//			{
//				return new JsonWriter(writer,JsonWriter.DROP_ROOT_MODE);
//			}
//		});
//		xxjson.alias("User",TestBean.class);
//		String testUserString2 = xxjson.toXML(testBean2);
//		System.out.println(testUserString2);
//		testUserString2 ="{'User':" +  testUserString2 + "}";
//		TestBean b2 = (TestBean)xxjson.fromXML(testUserString2);
//		System.out.println(b2.getAge());
//		System.out.println(b2.getName());
//		System.out.println("-----------json xml TestBean--------------");
//		
//	}
//}
