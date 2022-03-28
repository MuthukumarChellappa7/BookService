package com.bookstore.book.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * This class is model, which binds with book collection in mongodb.
 * 
 * @author Muthukumar Chellappa
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = "TBL_BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ")
	@SequenceGenerator(sequenceName = "BOOK_SEQ", allocationSize = 1, name = "BOOK_SEQ")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESC")
	private String description;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "BOOK_TYPE")
	private String bookType;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "ISBN")
	private String isbn;

}