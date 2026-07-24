package com.cognizant;

import com.cognizant.feign.LoanClient;
import com.cognizant.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanClient loanClient;

    @Test
    public void testGetAccount() throws Exception {
        mockMvc.perform(get("/accounts/00987987973432"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("00987987973432"))
                .andExpect(jsonPath("$.type").value("savings"))
                .andExpect(jsonPath("$.balance").value(234343.0));
    }
}
