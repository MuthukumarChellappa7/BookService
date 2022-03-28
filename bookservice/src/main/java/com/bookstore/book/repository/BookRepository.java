package com.bookstore.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.book.model.Book;

/**
 * This interface dedicatedly handles, book collection operation
 * 
 * @author Muthukumar Chellappa
 *
 */

public interface BookRepository extends JpaRepository<Book, Long>{	

}