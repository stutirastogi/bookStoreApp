package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author StutiRastogi
 *
 */
@Entity
@Table(name = "book")
public class Book extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	private Long isbn;

	@NotEmpty(message = "Please provide a title")
	private String title;

	@NotEmpty(message = "Please provide a author")
	private String author;

	@NotNull(message = "Please provide a price")
	private float price;

    @Column(columnDefinition = "integer default 1")
	private int availableCopies = 1;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

}
