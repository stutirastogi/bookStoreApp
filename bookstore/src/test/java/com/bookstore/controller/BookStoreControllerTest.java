package com.bookstore.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bookstore.BookstoreApplication;

/**
 * Unit test class for testing the rest api end points
 * 
 * @author StutiRastogi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { BookstoreApplication.class })
@AutoConfigureMockMvc
public class BookStoreControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void verifySearchBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/search/book?isbn=777").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.errorCode").value(404))
				.andExpect(jsonPath("$.message").value("The requested resource could not be found")).andDo(print());
	}

	@Test
	public void shouldSaveBookWhenValidRequest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
				.content("{\"isbn\":134,\"title\":\"reprehenderit\",\"author\":\"stuti\",\"price\":20}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.isbn").exists())
				.andExpect(jsonPath("$.title").exists()).andExpect(jsonPath("$.author").exists())
				.andExpect(jsonPath("$.price").exists()).andExpect(jsonPath("$.isbn").value(134))
				.andExpect(jsonPath("$.title").value("reprehenderit")).andExpect(jsonPath("$.author").value("stuti"))
				.andDo(print());
	}

	@Test
	public void verifyMalformedAddBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"isbn\": 134, \"author\" : \"xyz\", \"price\":30}").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status").value(400)).andExpect(jsonPath("$.errors").value("Please provide a title")).andDo(print());
	}

	@Test
	public void verifyInvalidBuyBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/buy/book?isbn=456").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.errorCode").value(404))
				.andExpect(jsonPath("$.message").value("The requested resource could not be found")).andDo(print());
	}

}
