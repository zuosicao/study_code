package cong.ruan.requests;

/**
 * 用户发给微信服务器，然后微信再发送过来的消息的基本类
 * @author RuanCong
 * @time 2014-4-27 下午1:07:40
 */
public class ReqBaseMessage
{
	 //   开发者微信号 
    private String ToUserName;  
    // 接收方帐号（收到的OpenID）,属性名开头字母之所以是大写，是为了方便用xstream框架生成与微信要求的格式的xml
    private String FromUserName;  
    // 消息创建时间 （整型）  
    private long CreateTime;  
    // 消息类型（text/music/news）  
    private String MsgType;
    //消息id
    private long MsgId;
    
    
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long msgId)
	{
		MsgId = msgId;
	}
	public String getToUserName()
	{
		return ToUserName;
	}
	public void setToUserName(String toUserName)
	{
		ToUserName = toUserName;
	}
	public String getFromUserName()
	{
		return FromUserName;
	}
	public void setFromUserName(String fromUserName)
	{
		FromUserName = fromUserName;
	}
	public long getCreateTime()
	{
		return CreateTime;
	}
	public void setCreateTime(long createTime)
	{
		CreateTime = createTime;
	}
	public String getMsgType()
	{
		return MsgType;
	}
	public void setMsgType(String msgType)
	{
		MsgType = msgType;
	}
	public ReqBaseMessage(String toUserName, String fromUserName,
			long createTime, String msgType,long mesId)
	{
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		MsgId = mesId;
	}
	public ReqBaseMessage()
	{
		
	}
    
}
