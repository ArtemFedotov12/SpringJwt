package com.start.integrationTesting.security.rest;


import com.start.integrationTesting.util.DtoFactory;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthenticationIntegrationTest extends AbstractIntegrationTest {

    @Sql(value = {"/sql/roleAdmin/create-user-roleAdmin-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleAdmin/delete-user-roleAdmin-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void successfulAuthenticationWithAdminRole() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(DtoFactory.generateAuthenticationDto("user1","12345"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("token")));
    }

    @Sql(value = {"/sql/roleUser/create-user-roleUser-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleUser/create-user-roleUser-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void successfulAuthenticationWithUserRole() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(DtoFactory.generateAuthenticationDto("user1","12345"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("token")));
    }

    @Sql(value = {"/sql/roleAdmin/create-user-roleAdmin-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleAdmin/delete-user-roleAdmin-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void unsuccessfulAuthenticationWithWrongPassword() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(DtoFactory.generateAuthenticationDto("user1","wrongPassword"))))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().string(not(containsString("token"))));
    }

    @Sql(value = {"/sql/roleUser/create-user-roleUser-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleUser/create-user-roleUser-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void unsuccessfulAuthenticationWithNotExistingUser() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(DtoFactory.generateAuthenticationDto("NotExistingUse","12345"))))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().string(not(containsString("token"))));
    }


}
