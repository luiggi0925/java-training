package ilan.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ilan.Application;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class IndexControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	IndexController indexController;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();	
	}

	@Test
	public void greeting_ShouldAddDefaultNameToModelAndRenderIndexView() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().attribute("name", is("Guest")));
	}
	
	@Test
	public void greeting_ShouldAddPassedParameterNameToModelAndRenderIndexView() throws Exception {
		mockMvc.perform(get("/?name=ilan")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().attribute("name", is("ilan")));
	}
	
	@Test
	public void handleLogin_ShouldRenderLoginView() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("loginView"));
	}


}