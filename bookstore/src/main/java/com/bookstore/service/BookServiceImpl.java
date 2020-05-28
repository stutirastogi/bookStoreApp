package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.elastic.PostRepository;
import com.bookstore.repository.jpa.BookRepository;

/**
 * 
 * @author StutiRastogi
 *
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PostRepository postRepository;

	@Override
	public Book save(Book book) {
		Book savedBook = bookRepository.findByIsbn(book.getIsbn());
		if (savedBook != null) {
			savedBook.setAvailableCopies(savedBook.getAvailableCopies() + 1);
		}
		return savedBook != null ? bookRepository.save(savedBook) : bookRepository.save(book);
	}

	@Override
	public List<Book> searchBook(Long isbn, String title, String author) {
		return bookRepository.searchBook(isbn, title, author);
	}

	@Override
	public Book getBookByIsbn(Long isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public Book buyBook(Long isbn) {
		Book book = bookRepository.findByIsbn(isbn);
		if (book != null && book.getAvailableCopies() > 0) {
			book.setAvailableCopies(book.getAvailableCopies() - 1);
			bookRepository.save(book);
			return book;
		}
		return null;
	}

	/**
	 * This method first finds the book title by its isbn number
	 * It then searches the elastic db for the title
	 */
	@Override
	public List<String> searchMediaCoverage(Long isbn) {
		List<String> list = new ArrayList<>();
		Book book = bookRepository.findByIsbn(isbn);
		if (book != null) {
			String title = book.getTitle();
			// Searches the elastic db for the book title
			postRepository.findPostsBySearchQuery(title).forEach(post -> list.add(post.getTitle()));
		}
		return list;
	}

}
