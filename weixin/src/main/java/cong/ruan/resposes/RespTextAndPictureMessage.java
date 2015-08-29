package cong.ruan.resposes;

import java.util.List;

public class RespTextAndPictureMessage extends RespBaseMessage
{
	public static String MESSAGE_TYPE = "news";//图文消息所属的消息类型
	
	public RespTextAndPictureMessage(String toUserName, String fromUserName,
			long createTime, String msgType,int articleCount,List<Article> articles)
	{
		super(toUserName, fromUserName, createTime, msgType);
		this.ArticleCount = articleCount;
		this.Articles = articles;
	}

	public RespTextAndPictureMessage()
	{
		
	}
	
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public int getArticleCount()
	{
		return ArticleCount;
	}

	public void setArticleCount(int articleCount)
	{
		ArticleCount = articleCount;
	}

	public List<Article> getArticles()
	{
		return Articles;
	}

	public void setArticles(List<Article> articles)
	{
		Articles = articles;
	}

}
