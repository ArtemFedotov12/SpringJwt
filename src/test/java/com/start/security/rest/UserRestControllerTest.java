package com.start.security.rest;


import com.start.AbstractRestControllerTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static com.start.util.LogInUtils.getTokenForLogin;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WithUserDetails("user1")
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserRestControllerTest extends AbstractRestControllerTest {


  @Test
   public void responseContainsAdminString() throws Exception {
     final String token = getTokenForLogin("user1", "12345", mockMvc);

      mockMvc.perform(get("/admin")
              .contentType(MediaType.APPLICATION_JSON)
              .header("Authorization", "Bearer " + token))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(content().string("admin"));
  }






}
