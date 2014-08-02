package br.com.mestres.ensino.webapp.spring.config;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.mestres.ensino.webapp.spring.controller.HelloWordController;




public class HelloWordTest {

	private static final String RESPONSE_BODY = "Hello Word";
	
    @InjectMocks
    private HelloWordController helloWordController;
 
    private MockMvc mockMvc;
 
    @Before	
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(helloWordController).build();
    }
    
    @Test
    public void testarRetotrnoControllerHello() throws Exception {
        this.mockMvc.perform(get("/hello")
        		.accept(MediaType.TEXT_HTML))
        		.andExpect(content().string(RESPONSE_BODY))
                .andExpect(status().isOk());
    }
}
