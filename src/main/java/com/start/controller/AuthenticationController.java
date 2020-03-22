package com.start.controller;

import com.start.config.JwtTokekUtil;
import com.start.model.dto.AuthenticationDto;
import com.start.model.dto.AuthTokenDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
@Api(value = "AuthenticationController")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokekUtil jwtTokenUtil;

    @PostMapping
    @ApiOperation("Token's generation")
    public ResponseEntity<?> register(@RequestBody AuthenticationDto authenticationDto) throws AuthenticationException {

        //UserDetailsService -> loadUserByUsername(String username) is called
        // see javaDoc  ---- authenticationManager.authenticate
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getUsername(),
                        authenticationDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthTokenDto(token));
    }

}
