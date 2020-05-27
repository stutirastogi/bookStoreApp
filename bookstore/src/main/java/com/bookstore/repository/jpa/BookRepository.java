package com.bookstore.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

/**
 * 
 * @author StutiRastogi
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
	
	@Query("SELECT b FROM Book b WHERE b.isbn = :isbn")
	public Book findByIsbn(@Param("isbn") Long isbn);
	

}
