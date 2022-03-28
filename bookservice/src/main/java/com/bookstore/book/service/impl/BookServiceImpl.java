package com.bookstore.book.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.book.configuration.PromotionConfigProperties;
import com.bookstore.book.exception.BookNotFoundException;
import com.bookstore.book.helper.BookHelper;
import com.bookstore.book.model.Book;
import com.bookstore.book.repository.BookRepository;
import com.bookstore.book.service.BookService;
import com.bookstore.book.transferobjects.dto.BookDTO;

/**
 * This class has service implementation. Service layer.
 * 
 * @author Muthukumar Chellappa
 *
 */

@Service
public class BookServiceImpl implements BookService {

	private final Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PromotionConfigProperties promotionConfigProperties;

	@Override
	public Book saveBook(BookDTO bookDTO) {

		Book book = new Book();
		BeanUtils.copyProperties(bookDTO, book); 
		return bookRepository.save(book);

	}

	@Override
	public Book updateBook(BookDTO bookDTO) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDTO, book);
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) throws BookNotFoundException {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
	}

	@Override
	public BigDecimal chkoutBooksWithPayableAmount(List<Book> books, String promocode) {

		Map<String, BigDecimal> promoMap = BookHelper.buildPromoCodeMap(promotionConfigProperties);

		log.info("promoMap value => {}", promoMap);

		return new BigDecimal(books.stream().map(book -> {
			if (promocode != null && !promocode.isEmpty()) {
				BigDecimal discountPerchent = promoMap
						.get(promocode);
				if (discountPerchent != null && discountPerchent.compareTo(BigDecimal.ZERO) > 0) {
					return book.getPrice()
							.subtract(book.getPrice().multiply(discountPerchent).divide(BigDecimal.valueOf(100)));
				} else {
					return book.getPrice();
				}
			} else {
				return book.getPrice();
			}
		}).mapToDouble(BigDecimal::doubleValue).sum());

	}

	@Override
	public void deleteAllBooks() {
		bookRepository.deleteAll();
	}

}
