package fr.visiplus.book.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void reserve() throws Exception {
		mockMvc.perform(post("/book/reserve/3/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.bookDTO.status").value("BOOKED"));
	}
}
