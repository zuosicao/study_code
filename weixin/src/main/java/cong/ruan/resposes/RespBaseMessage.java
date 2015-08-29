package cong.ruan.resposes;

/**
 * 所有回复消息的基本属性
 * @author RuanCong
 * @time 2014-4-26 下午3:15:14
 */
public class RespBaseMessage
{
	 // 接收方帐号（收到的OpenID）,属性名开头字母之所以是大写，是为了方便用xstream框架生成与微信要求的格式的xml  
    private String ToUserName;  
    // 开发者微信号  
    private String FromUserName;  
    // 消息创建时间 （整型）  
    private long CreateTime;  
    // 消息类型（text/music/news）  
    private String MsgType;
	
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
	
	/**
	 * 全部属性构造函数
	 * @param toUserName
	 * @param fromUserName
	 * @param createTime
	 * @param msgType
	 */
	public RespBaseMessage(String toUserName, String fromUserName,
			long createTime, String msgType)
	{
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	} 
	
	//空构造函数
	public RespBaseMessage()
	{
		
	}
    
}
