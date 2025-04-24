package com.article.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.article.entity.Article;
import com.article.entity.Category;
import com.article.utils.HibernateUtils;

public class AddArticleExampleMain {
	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Article art = new Article(103,"The Thinker",Category.valueOf("ARTIFACT"),LocalDate.parse("1904-09-25"),"Auguste Rodin");
			Transaction tx = session.beginTransaction();
				session.persist(art);
			tx.commit();
			System.out.println("Record added successfully...");
		}
		

	}
}
