package com.article.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.article.entity.Article;
import com.article.utils.HibernateUtils;

public class ShowArticleExampleMain {
	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
					Class<Article> entityType = Article.class;
					Object id = 101;
					Article foundArticle = session.find(entityType, id);
					if(foundArticle != null) {
					System.out.println("Found Article: "+foundArticle);
					System.out.println("Name: "+foundArticle.getName());
					System.out.println("Creator Name: "+foundArticle.getCreator_name());
					}else
						System.out.println("Article with given ID does not exist");
					}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
