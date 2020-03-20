package com.start.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthTokenDto {

    private String token;

    public AuthTokenDto(String token) {
        this.token = token;
    }


}
