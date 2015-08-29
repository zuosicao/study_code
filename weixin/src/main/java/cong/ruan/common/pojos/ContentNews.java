package cong.ruan.common.pojos;

import java.util.List;

/**
 * 具体新闻类
 * @author RuanCong
 * @time 2014-4-28 下午9:12:05
 */
public class ContentNews
{
	private String newsTitle;//标题
	private List<String> contents;//新闻具体内容
	
	public String getNewsTitle()
	{
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}
	public List<String> getContents()
	{
		return contents;
	}
	public void setContents(List<String> contents)
	{
		this.contents = contents;
	}
	public ContentNews(String newsTitle, List<String> contents)
	{
		this.newsTitle = newsTitle;
		this.contents = contents;
	}
	public ContentNews()
	{
	}
}
