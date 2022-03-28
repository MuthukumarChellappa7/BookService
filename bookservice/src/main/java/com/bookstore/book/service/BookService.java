package com.bookstore.book.service;

import java.math.BigDecimal;
import java.util.List;

import com.bookstore.book.exception.BookNotFoundException;
import com.bookstore.book.model.Book;
import com.bookstore.book.transferobjects.dto.BookDTO;

/**
 * This class has book services declaration.
 * 
 * @author Muthukumar Chellappa
 *
 */

public interface BookService {

	public Book saveBook(BookDTO bookDTO);
	public Book updateBook(BookDTO bookDTO);
	public void deleteBookById(Long id);
	public List<Book> findAllBooks();
	public Book findBookById(Long id) throws BookNotFoundException;
	public BigDecimal chkoutBooksWithPayableAmount(List<Book> books, String promocode);
	public void deleteAllBooks();

}
