package com.start.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AuthTokenDto implements Serializable {

    private static final long serialVersionUID = -1460269587503236883L;
    private String token;

    public AuthTokenDto(String token) {
        this.token = token;
    }


}
