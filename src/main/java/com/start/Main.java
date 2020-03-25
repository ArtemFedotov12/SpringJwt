package com.start;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.Gson;
import com.start.model.dto.AuthenticationDto;

public class Main {
    private static final Gson GSON = new Gson();
    public static void main(String[] args) {
        AuthenticationDto authenticationDto =  new AuthenticationDto("user1","12345");

        System.out.println(GSON.toJson(authenticationDto));
    }

    private static class AuthenticationResponse {

        private String idToken;

        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        public String getIdToken() {
            return idToken;
        }
    }
}
