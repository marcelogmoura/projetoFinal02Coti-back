package com.mgmoura;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.mgmoura.dtos.ContatoPostDto;
import com.mgmoura.entities.Contato;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjetoFinal02ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	
	private static Contato contato;

	@Test
	@Order(1)
	public void testCriarContato() throws Exception {

		ContatoPostDto post = new ContatoPostDto();
		Faker faker = new Faker();

		post.setNome(faker.name().fullName());
		post.setEmail(faker.internet().emailAddress());
		post.setTelefone("1111-2222");

		MvcResult result = mockMvc.perform(post("/api/contatos") 
				.contentType("application/json")
				.content(mapper.writeValueAsString(post)))
				.andExpect(status().isCreated()).andReturn();
	}
	
	
	@Test
	@Order(2)
	public void testEditarContato() throws Exception {
		
		fail("2");
		
	}
	
	
	@Test
	@Order(3)
	public void testContatoGetAll() throws Exception {
		
		mockMvc.perform(get("/api/contatos")).andExpect(status().isOk());
		
	}
	
	
	@Test
	@Order(4)
	public void testContatoGetById() throws Exception {
		
		mockMvc.perform(get("/api/contatos/obterPorId/" + contato.getIdContato()))
				.andExpect(status()
						.isOk());
	}

}






