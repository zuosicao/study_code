//package cong.ruan.test;
//
//import java.io.Writer;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.core.util.QuickWriter;
//import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
//import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
//import com.thoughtworks.xstream.io.xml.XppDriver;
//
//import cong.ruan.beans.TextMessage;
//
//public class TestXmlByXStream
//{
//	public static void main(String[] args)
//	{
//		TextMessage text = new TextMessage("to", "from", "11111", "text",
//				"content", "111122");
//		XStream xmStream = new XStream(new XppDriver()
//		{
//			public HierarchicalStreamWriter createWriter(Writer out)
//			{
//				return new PrettyPrintWriter(out)
//				{
//					// 对所有xml节点的转换都增加CDATA标记
//					boolean cdata1 = true;
//
//					protected void writeText(QuickWriter writer, String text)
//					{
//						if (cdata1)
//						{
//							writer.write("<![CDATA[");
//							writer.write(text);
//							writer.write("]]>");
//						} else
//						{
//							writer.write(text);
//						}
//					}
//					
//				
//				};
//			}
//		});
//		xmStream.alias("xml", TextMessage.class);
//		xmStream.aliasField("MsgId", TextMessage.class, "msgId");
//		String result = xmStream.toXML(text);
//		System.out.println(result);
//		System.out.println("........................................");
//		String src = "<xml><toUserName><![CDATA[to]]></toUserName><fromUserName><![CDATA[from]]></fromUserName><createTime><![CDATA[11111]]></createTime><msgType><![CDATA[text]]></msgType><content><![CDATA[content]]></content><MsgId><![CDATA[111122]]></MsgId></xml>";
//		XStream x = new XStream();
//		x.alias("xml",TextMessage.class);
//		x.aliasField("MsgId", TextMessage.class, "msgId");
//		TextMessage me = (TextMessage)x.fromXML(src);
//		System.out.println(me.getMsgId());
//		System.out.println(me.getCreateTime());
//	}
//}
