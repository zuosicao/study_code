package cong.ruan.requests;

/**
 * 文本消息
 * 用户发给微信服务器，然后微信再发送过来的  文本消息  的基本类
 * @author RuanCong
 * @time 2014-4-27 下午1:10:44
 */
public class ReqTextMessage extends ReqBaseMessage
{
	private String Content;

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		Content = content;
	}

	public ReqTextMessage(String toUserName, String fromUserName,
			long createTime, String msgType,long mesId,String content)
	{
		super(toUserName, fromUserName,createTime, msgType, mesId);
		Content = content;
	}
	
	public ReqTextMessage()
	{
		
	}
	
}
