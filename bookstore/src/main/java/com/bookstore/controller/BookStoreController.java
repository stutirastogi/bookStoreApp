package com.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.common.ApiConstants;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Book;
import com.bookstore.service.BookService;

/**
 * Rest Controller for the apis used in application
 * 
 * @author StutiRastogi
 *
 */
@RestController
@RequestMapping("/api")
public class BookStoreController {

	@Autowired
	private BookService mBookService;

	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
		return new ResponseEntity<Book>(mBookService.save(book), HttpStatus.OK);
	}

	@PutMapping("/buy/book")
	public ResponseEntity<Book> buyBook(@RequestParam("isbn") Long isbn) throws ResourceNotFoundException {
		Book book = mBookService.buyBook(isbn);
		if (null == book) {
			throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND_EXCEPTION);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/search/book")
	public ResponseEntity<List<Book>> searchBook(@RequestParam(value = "isbn", required = false) Long isbn,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author) throws ResourceNotFoundException {

		List<Book> bookList = mBookService.searchBook(isbn, title, author);
		if (bookList == null || bookList.isEmpty()) {
			throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND_EXCEPTION);
		}
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}

	@GetMapping("/search/media")
	public ResponseEntity<List<String>> searchMediaCover(@RequestParam("isbn") Long isbn) {
		return new ResponseEntity<List<String>>(mBookService.searchMediaCoverage(isbn), HttpStatus.OK);
	}

}
