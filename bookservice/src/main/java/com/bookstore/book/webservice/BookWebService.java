package com.bookstore.book.webservice;

import static com.bookstore.book.constants.ResourceUrl.BOOKS;
import static com.bookstore.book.constants.ResourceUrl.BOOKS_CHECKOUT;
import static com.bookstore.book.constants.ResourceUrl.BOOKS_ID;
import static com.bookstore.book.constants.ResourceUrl.VERSION_V1;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.book.configuration.PromotionConfigProperties;
import com.bookstore.book.exception.BookNotFoundException;
import com.bookstore.book.model.Book;
import com.bookstore.book.service.BookService;
import com.bookstore.book.transferobjects.dto.BookDTO;

/**
 * This controller, Rest webservice layer.
 * 
 * @author Muthukumar Chellappa
 *
 */

@RestController
@RequestMapping(VERSION_V1)
public class BookWebService {

	private final Logger log = LoggerFactory.getLogger(BookWebService.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private PromotionConfigProperties applicationProperties;

	@GetMapping(value = BOOKS)
	public List<Book> findAllBooks() {
		log.info("Entered inside Webservice Layer, Service => find All books ");
		return bookService.findAllBooks();
	}

	@GetMapping(value = BOOKS_ID)
	public Book findBookById(@PathVariable Long id) throws BookNotFoundException {
		log.info("Entered inside Webservice Layer, Service => findBookById, id => {} ", id);
		return bookService.findBookById(id);
	}

	@PostMapping(value = BOOKS)
	public Book saveNewBook(@RequestBody BookDTO bookDTO) {
		log.info("Entered inside Webservice Layer, Service => saveNewBook, BookDTO => {} ", bookDTO);
		return bookService.saveBook(bookDTO);

	}

	@PutMapping(value = BOOKS)
	public Book updateBook(@RequestBody BookDTO bookDTO) {
		log.info("Entered inside Webservice Layer, Service => updateBook, BookDTO => {} ", bookDTO);
		return bookService.updateBook(bookDTO);

	}

	@DeleteMapping(value = BOOKS_ID)
	public void deleteBookById(@PathVariable Long id) {
		log.info("Entered inside Webservice Layer, Service => deleteBookById, id => {} ", id);
		bookService.deleteBookById(id);
	}

	@DeleteMapping(value = BOOKS)
	public void deleteAllBooks() {
		log.info("Entered inside Webservice Layer, Service => deleteAllBooks");
		bookService.deleteAllBooks();
	}

	@PostMapping(value = BOOKS_CHECKOUT)
	public BigDecimal chkoutBooksWithPayableAmount(@RequestBody List<Book> books,
			@RequestParam(required = false) String promocode) {
		log.info("Entered inside Webservice Layer, Service => chkoutBooksWithPayableAmount, books => {}, promocode => {}",
				books, promocode);
		return bookService.chkoutBooksWithPayableAmount(books, promocode);
	}

}