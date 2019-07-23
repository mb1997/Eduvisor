package com.application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.application.model.Login;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {

	@Autowired
    private WebApplicationContext wac;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper om;
	
	@Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
	@Test
    public void testHomePage() throws Exception {
		mockMvc.perform(get("/index"))
                .andExpect(redirectedUrl(""))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
	
	@Test
	public void HomePage2() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"))
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}
	
	//LOGIN PAGE LOAD TESTING
	//.perform to send url link
	//andExpect to check the values retrieved in response with the given data
	//status().isOk() is to check whether link is proper or not.. (Error 404 or Error 500 checking)
	//view().name() is to check whether the link returns particular file with that name or not
	//andDo() will perform operation to be done after all things are true.
	@Test
	public void LoginPageLoading() throws Exception {
		mockMvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}
	
	//REGISTER MAPPING TESTING
	@Test
	public void RegisterationPageLoading() throws Exception {
		mockMvc.perform(get("/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}
	
	@Test
	public void LoginPageCase1Test() throws Exception {
		Login user = new Login();
		user.setEmail("ojhaharsh7@gmail.com");
		user.setPassword("Ojhaharsh7@");
		System.out.println(om.writeValueAsString(user));
		mockMvc.perform(post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(user))
				)
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}

}
