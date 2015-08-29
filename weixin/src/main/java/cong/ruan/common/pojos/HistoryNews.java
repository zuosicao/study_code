package cong.ruan.common.pojos;

/**
 * 历史信息
 * @author RuanCong
 * @time 2014-4-28 下午7:15:36
 */
public class HistoryNews
{
	private String newsTitle;//标题
	private String newsNumber;//根据具体链接解析后的新闻序号
	
	public HistoryNews(String newsTitle, String newsNumber)
	{
		super();
		this.newsTitle = newsTitle;
		this.newsNumber = newsNumber;
	}
	public String getNewsTitle()
	{
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}
	public String getNewsNumber()
	{
		return newsNumber;
	}
	public void setNewsNumber(String newsUrl)
	{
		this.newsNumber = newsUrl;
	}
	
}
