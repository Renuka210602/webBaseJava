package com.article.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.article.entity.Article;
import com.article.utils.HibernateUtils;


public class UpdateArticleExampleMain {
	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
					Class<Article> entityType = Article.class;
					Object id = 103;
					Article foundArticle = session.find(entityType, id);
					if(foundArticle != null) {
						Transaction tx = session.beginTransaction();
						foundArticle.setCreator_name("xyz");
						tx.commit();
						System.out.println("Record Updated Successfully..");
					}else {
						System.out.println("Article with given ID does not exist");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}

	}

}
