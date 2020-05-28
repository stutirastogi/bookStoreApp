package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

/**
 * 
 * @author StutiRastogi
 *
 */
public interface BookService {

	/**
	 * Save the book object
	 * 
	 * @param book
	 * @return
	 */
	Book save(Book book);

	/**
	 * Search book given it's isbn/title/author
	 * 
	 * @param isbn
	 * @param title
	 * @param author
	 * @return
	 */
	List<Book> searchBook(Long isbn, String title, String author);

	/**
	 * Buy a book given it's isbn number
	 * 
	 * @param isbn
	 * @return
	 */
	Book buyBook(Long isbn);

	/**
	 * Search media coverage of a book given it's isbn number
	 * 
	 * @param title
	 * @return
	 */
	List<String> searchMediaCoverage(Long isbn);

	/**
	 * Fetch a book by its isbn number
	 * 
	 * @param isbn
	 * @return
	 */
	Book getBookByIsbn(Long isbn);

}
