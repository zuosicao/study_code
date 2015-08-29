package cong.ruan.resposes;

public class RespTextMessage extends RespBaseMessage
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

	public RespTextMessage()
	{
		super();
	}

	public RespTextMessage(String toUserName, String fromUserName,
			long createTime, String msgType,String content)
	{
		super(toUserName, fromUserName, createTime, msgType);
		this.Content = content;
	}
	
}
