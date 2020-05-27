package com.bookstore.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.Book;

@Repository
@Transactional(readOnly = true)
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Book> searchBook(Long isbn, String title, String author) {
		Query result = null;

		StringBuilder query = new StringBuilder("FROM Book WHERE ");
		
		// if isbn is given, we don't need anything else since it is unique
		if (isbn != null) {
			query.append("isbn = " + isbn);
		} else {
			if (title != null) {
				query.append(" title LIKE '%" + title + "%'");
			}
			if (author != null) {
				if (title != null)
					query.append(" AND ");
				query.append(" author LIKE '%" + author + "%'");
			}
		}

		result = entityManager.createQuery(query.toString());

		List<Book> bookList = result.getResultList();
		System.out.println(bookList);
		return bookList;

	}

}
