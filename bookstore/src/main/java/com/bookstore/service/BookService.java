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
	 * 
	 * @param book
	 * @return
	 */
	public Book save(Book book);

	/**
	 * 
	 * @param isbn
	 * @param title
	 * @param author
	 * @return
	 */
	public List<Book> searchBook(Long isbn, String title, String author);

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public Book buyBook(Long isbn);

	/**
	 * 
	 * @param title
	 * @return
	 */
	public List<String> searchMediaCoverage(Long isbn);
	
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	Book getBookByIsbn(Long isbn);

}
