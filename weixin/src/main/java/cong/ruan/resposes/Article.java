package cong.ruan.resposes;

/**
 * 图文消息里要用到的文章类
 * @author RuanCong
 * @time 2014-4-26 下午3:23:40
 */
public class Article
{
	  // 图文消息名称  
    private String Title;  
    // 图文消息描述  
    private String Description;  
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，
    private String PicUrl;  
    // 点击图文消息跳转链接  
    private String Url;
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String title)
	{
		Title = title;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String description)
	{
		Description = description;
	}
	public String getPicUrl()
	{
		return PicUrl;
	}
	public void setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
	}
	public String getUrl()
	{
		return Url;
	}
	public void setUrl(String url)
	{
		Url = url;
	}
	
	public Article(String title, String description, String picUrl, String url)
	{
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
	}
    
	public Article()
	{
		
	}
}
