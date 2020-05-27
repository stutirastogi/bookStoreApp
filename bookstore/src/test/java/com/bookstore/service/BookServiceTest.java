package com.bookstore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookstore.BookstoreApplication;
import com.bookstore.model.Book;
import com.bookstore.repository.jpa.BookRepository;
import com.bookstore.service.BookService;

/**
 * Unit test class for testing the service layer
 * 
 * @author StutiRastogi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { BookstoreApplication.class })
public class BookServiceTest {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Test
	public void shouldReturnBookWhenSuccessfullySaved() {
		Book book = new Book();
		book.setIsbn(125L);
		book.setTitle("Two and a half men");
		book.setAuthor("Stuti");
		book.setPrice(90f);
		book.setAvailableCopies(1);
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.save(book));
	}

	@Test
	public void shouldReturnBookWhenBuyBookIsCalled() {

		Book book = new Book();
		book.setIsbn(125L);
		book.setTitle("Two and a half men");
		book.setAuthor("Stuti");
		book.setPrice(100f);
		book.setAvailableCopies(1);
		when(bookRepository.findByIsbn(125L)).thenReturn(book);
		assertEquals(book, bookService.buyBook(125L));
	}

	@Test
	public void searchBookTest() {
		Long isbn = 125L;
		String title = "Two and a half men";
		String author = "Stuti";
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(100f);
		book.setAvailableCopies(1);

		List<Book> bookList = Arrays.asList(book);

		when(bookRepository.searchBook(isbn, title, author)).thenReturn(bookList);
		assertEquals(bookList, bookService.searchBook(isbn, title, author));

		when(bookRepository.searchBook(isbn, null, null)).thenReturn(bookList);
		assertEquals(bookList, bookService.searchBook(isbn, null, null));

		when(bookRepository.searchBook(null, title, null)).thenReturn(bookList);
		assertEquals(bookList, bookService.searchBook(null, title, null));

		when(bookRepository.searchBook(null, null, author)).thenReturn(bookList);
		assertEquals(bookList, bookService.searchBook(null, null, author));

	}

}
