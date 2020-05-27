package com.bookstore.repository.jpa;

import java.util.List;

import com.bookstore.model.Book;

/**
 * This interface is created for writing custom sql queries that 
 * are not directly supported by spring data jpa.
 * 
 * @author StutiRastogi
 *
 */
public interface BookRepositoryCustom {

	/**
	 * searches a book 
	 * @param isbn
	 * @param title
	 * @param author
	 * @return
	 */
	 List<Book> searchBook(Long isbn, String title, String author) ;
}
