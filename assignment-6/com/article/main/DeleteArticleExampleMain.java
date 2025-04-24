package com.article.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.article.entity.Article;
import com.article.utils.HibernateUtils;

public class DeleteArticleExampleMain {
	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
					Class<Article> entityType = Article.class;
					Object id = 102;
					Article foundArticle = session.find(entityType, id);
					if(foundArticle != null) {
						Transaction tx = session.beginTransaction();
							session.remove(foundArticle);
						tx.commit();
						System.out.println("Record Deleted Successfully..");
					}else {
						System.out.println("Article with given ID does not exist");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}

	}
}
