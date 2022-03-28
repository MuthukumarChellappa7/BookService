package com.bookstore.book.transferobjects.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * This class is data transfer for book properties
 * 
 * @author Muthukumar Chellappa
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BookDTO {

	private Long id;
	@NotBlank(message="Book name cannot be empty.")
	private String name;
	private String description;
	private String author;
	@NotBlank(message="Book type cannot be empty.")
	private String bookType;
	@NotBlank(message="Book price cannot be empty.")
	private BigDecimal price;
	@NotBlank(message="isbn cannot be empty.")
	private String isbn;

}