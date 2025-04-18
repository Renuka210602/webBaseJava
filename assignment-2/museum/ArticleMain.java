package com.museum;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Scanner;

import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.exception.ResourceNotFoundArticle;
import com.museum.service.article_service;
public class ArticleMain {
	public static void main(String args[])   {
		Scanner sc = new Scanner(System.in);
		article_service service=null;
		try {
			 service = new article_service();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		boolean exit = true;
		while(exit)
		{
		System.out.println("----Menu----"+
		"\n1.Add Article"+"\n2.Display All Articles"+"\n3.Display Details of Article"+
				"\n4.Update Article"+"\n5.Delete Article"+"\n0.Exit");
		System.out.println("Enter choice");
		int ch =  sc.nextInt();
		switch(ch) {
		case 1:{
			try {
				System.out.println("Enter article name,category(PAINTING, SCULPTURE, ARTIFACT),created_date, creator_name: ");
				String name = sc.next();
				Category category = Category.valueOf(sc.next());
				LocalDate date = LocalDate.parse(sc.next());
				String creatorName = sc.next();
				service.addArticle(name, category, date, creatorName);
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}	
		case 2:{
			try {
				service.displayAllArticles();
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 3:{
			try {
				System.out.println("Enter article id: ");
				service.displayArticleDetails(sc.nextInt());
			}catch(SQLException | ResourceNotFoundArticle e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 4:{
			try {
				System.out.println("Enter article id,article name,category(PAINTING, SCULPTURE, ARTIFACT),created_date, creator_name: ");
				service.updateArticle(sc.nextInt(),sc.next(),Category.valueOf(sc.next()),LocalDate.parse(sc.next()),sc.next());
			}catch(SQLException | ResourceNotFoundArticle e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 5:{
			try {
				System.out.println("Enter article id: ");
				 int id = sc.nextInt();
			        service.delete(id);
			}catch(SQLException  | ResourceNotFoundArticle e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 0:{
			exit=false;
			System.out.println("Thank You");
			break;
		}
		default:
			System.out.println("Invalid choice...");
		}
	}
	}
}
