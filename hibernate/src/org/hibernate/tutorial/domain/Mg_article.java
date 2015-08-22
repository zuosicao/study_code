package org.hibernate.tutorial.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "mg_article")
public class Mg_article {	//文章

	public static int RECOMMED_DEFAULT = 0;//不做任何推荐
	public static int RECOMMED = 1;//文章推荐
	public static int RECOMMED_TOP = 2;//文章置顶
	
	@Id
	@GeneratedValue
	private int acticleid;		//文章编号		
	private Integer article_cat_id;//文章目录编号,当为null时，为用户分布的文章
	private Integer userid;		//用户编号 ,当为null时，为后台分布的文章
	private String title;
	
	private String content;		//文章内容
	private int is_recommen;	//是否推荐或置顶
	private Timestamp publish_time;//文章发布时间 
	
	@OneToMany(mappedBy="article",cascade=CascadeType.REMOVE)
	private List<Mg_article_favorite> favorited;
	
	
	public int getActicleid() {
		return acticleid;
	}

	public void setActicleid(int acticleid) {
		this.acticleid = acticleid;
	}
	
	public Integer getArticle_cat_id() {
		return article_cat_id;
	}

	public void setArticle_cat_id(Integer article_cat_id) {
		this.article_cat_id = article_cat_id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "content")
	@Type(type="text")//add by ruancong 将文章的正文字段类型设置为text
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIs_recommen() {
		return is_recommen;
	}
	public void setIs_recommen(int is_recommen) {
		this.is_recommen = is_recommen;
	}

	public Timestamp getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}

	public List<Mg_article_favorite> getFavorited() {
		return favorited;
	}

	public void setFavorited(List<Mg_article_favorite> favorited) {
		this.favorited = favorited;
	}
	
	
	
}
