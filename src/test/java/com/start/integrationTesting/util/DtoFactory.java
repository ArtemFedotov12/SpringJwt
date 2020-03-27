package com.start.integrationTesting.util;

import com.start.model.dto.AbstractDto;
import com.start.model.dto.AuthenticationDto;

import java.util.HashMap;
import java.util.Map;

public class DtoFactory {

    private static final Map<String, AbstractDto> DTO_MAP = new HashMap<>();

    public static AuthenticationDto generateAuthenticationDto(String userName, String password) {
        AuthenticationDto authenticationDto = (AuthenticationDto) DTO_MAP.get(AuthenticationDto.class.getSimpleName());

        if (authenticationDto == null) {

            authenticationDto = new AuthenticationDto();
            authenticationDto.setUsername(userName);
            authenticationDto.setPassword(password);

            DTO_MAP.put(AuthenticationDto.class.getSimpleName(), authenticationDto);
        } else {
            authenticationDto.setUsername(userName);
            authenticationDto.setPassword(password);
        }

        return authenticationDto;
    }

}

