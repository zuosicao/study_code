package org.hibernate.tutorial.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文章收藏
 */
@Entity
@Table(name="mg_article_favorite")
public class Mg_article_favorite {
	@Id
	@GeneratedValue
	private int favorite_id;
	
	@ManyToOne
	@JoinColumn(name = "articleid")
	private Mg_article article;//文章id
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private Mg_user user;//用户id

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public Mg_article getArticle() {
		return article;
	}

	public void setArticle(Mg_article article) {
		this.article = article;
	}

	public Mg_user getUser() {
		return user;
	}

	public void setUser(Mg_user user) {
		this.user = user;
	}
}
