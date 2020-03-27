package com.start.integrationTesting.security.rest;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static com.start.integrationTesting.util.LogInUtils.getTokenForLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestControllerTest extends AbstractIntegrationTest {

    @Sql(value = {"/sql/roleUser/create-user-roleUser-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleUser/create-user-roleUser-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void successGettingResponseUserRole() throws Exception {
        final String token = getTokenForLogin("user1", "12345", mockMvc);

        mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("user"));
    }


    @Sql(value = {"/sql/roleAdmin/create-user-roleAdmin-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleAdmin/delete-user-roleAdmin-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void successGettingResponse() throws Exception {
        final String token = getTokenForLogin("user1", "12345", mockMvc);

        mockMvc.perform(get("/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("admin"));
    }

    @Sql(value = {"/sql/roleUser/create-user-roleUser-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/roleUser/create-user-roleUser-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    public void forbiddenGettingResponse() throws Exception {
        final String token = getTokenForLogin("user1", "12345", mockMvc);

        mockMvc.perform(get("/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

}
