package com.start.security.rest;


import com.start.AbstractRestControllerTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthenticationRestControllerTest extends AbstractRestControllerTest {

    @Test
    public void s() {

    }

    @Test
    public void successfulAuthenticationWithUser() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"password\": \"12345\", \"username\": \"user1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("token")));
    }

    @Test
    public void unsuccessfulAuthenticationWithDisabled() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"password\": \"password\", \"username\": \"disabled\"}"))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().string(not(containsString("token"))));
    }



}
