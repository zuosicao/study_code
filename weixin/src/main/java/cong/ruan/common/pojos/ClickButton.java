package cong.ruan.common.pojos;

/**
 * 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event	的结构给开发者（参考消息接口指南），
 * 并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互；
 * @author RuanCong
 * @time 2014-4-28 下午2:54:09
 */
public class ClickButton extends Button
{
	private String type;
	private String key;
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
}
