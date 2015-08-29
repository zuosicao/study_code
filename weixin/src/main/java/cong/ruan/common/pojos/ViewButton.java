package cong.ruan.common.pojos;

/**
 * 用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的url值	（即网页链接），
 * 达到打开网页的目的，建议与网页授权获取用户基本信息接口结合，获得用户的登入个人信息
 * @author RuanCong
 * @time 2014-4-28 下午2:55:05
 */
public class ViewButton extends Button
{
	private String type;
	private String url;
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	
}
