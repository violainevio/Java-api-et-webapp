package com.openclassrooms.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void testGetEmployees() throws Exception {

		mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName", is("Sophie")));

	}

}

//@WebMvcTest(controllers = EmployeeController.class)
//public class EmployeeControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeService employeeService;
//
//	@Test
//	public void testGetEmployees() throws Exception {
//		mockMvc.perform(get("/employees")).andExpect(status().isOk());
//	}
//
//}
