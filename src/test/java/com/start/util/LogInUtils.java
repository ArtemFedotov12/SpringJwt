package com.start.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.start.model.dto.AuthenticationDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public final class LogInUtils {

   private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
   private static final Gson GSON = new Gson();

   private LogInUtils() {
   }

   public static String getTokenForLogin(String username, String password, MockMvc mockMvc) throws Exception {
      String content = mockMvc.perform(post("/login")
         .contentType(MediaType.APPLICATION_JSON)
              //.content(GSON.toJson(getAuthenticationDto(username,password))))
              .content(GSON.toJson(generateAuthenticationDto(username,password))))
         .andReturn()
         .getResponse()
         .getContentAsString();
      AuthenticationResponse authResponse = OBJECT_MAPPER.readValue(content, AuthenticationResponse.class);

      return authResponse.getToken();
   }

   private static AuthenticationDto generateAuthenticationDto(String userName, String password) {
      AuthenticationDto authenticationDto = new AuthenticationDto();
      authenticationDto.setUsername(userName);
      authenticationDto.setPassword(password);
      return authenticationDto;
   }

   @Getter
   @Setter
   private static class AuthenticationResponse {

      //@JsonAlias("id_token")
      private String token;


   }
}
