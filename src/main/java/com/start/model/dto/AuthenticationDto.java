package com.start.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationDto extends AbstractDto{

    private static final long serialVersionUID = -46434441822649558L;

    private String username;
    private String password;


}
