package com.bookstore.book;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bookstore.book.configuration.PromotionConfigProperties;
import com.bookstore.book.service.BookService;
import com.bookstore.book.transferobjects.dto.BookDTO;
import com.bookstore.book.webservice.BookWebService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookWebService.class)
class BookWebServiceTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@MockBean
	private PromotionConfigProperties applicationProperties;

	@Test
	public void findAllBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/books").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void findBookById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/books/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void saveNewBook() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/v1/books").content(new ObjectMapper().writeValueAsString(new BookDTO()))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void updateBook() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.put("/v1/books").content(new ObjectMapper().writeValueAsString(new BookDTO()))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteBookById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/v1/books/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteAllBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/v1/books").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void booksCheckOut() throws Exception {

		List<BookDTO> books = new ArrayList();
		books.add(new BookDTO());

		mockMvc.perform(
				MockMvcRequestBuilders.post("/v1/books/checkout").content(new ObjectMapper().writeValueAsString(books))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
