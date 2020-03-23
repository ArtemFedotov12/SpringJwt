package com.start.controller;

import com.start.config.JwtTokekUtil;
import com.start.model.dto.AuthTokenDto;
import com.start.model.dto.AuthenticationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
@Api(value = "AuthenticationController")
public class AuthenticationController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokekUtil jwtTokenUtil;

    public AuthenticationController(AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokekUtil jwtTokenUtil) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    @ApiOperation("Token's generation")
    public ResponseEntity<AuthTokenDto> register(@RequestBody AuthenticationDto authenticationDto) throws AuthenticationException {

        //UserDetailsService -> loadUserByUsername(String username) is called
        // see javaDoc  ---- authenticationManager.authenticate
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getPassword());

        final Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthTokenDto(token));
    }

}
