package com.museum.entity;

import java.time.LocalDate;

public class Article {
	private Integer id;
	private String name;
	private Category category;
	private LocalDate created_date;
	private String creator_name;
	
	public Article() {
		
	}
	
	public Article(Integer id, String name, Category category, LocalDate created_date, String creator_name) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.created_date = created_date;
		this.creator_name = creator_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", category=" + category + ", created_date=" + created_date
				+ ", creator_name=" + creator_name + "]";
	}
	
	
	
}
