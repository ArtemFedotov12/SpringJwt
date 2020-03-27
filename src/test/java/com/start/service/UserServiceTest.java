package com.start.service;

import com.start.Application;
import com.start.model.dto.UserDto;
import com.start.model.entities.User;
import com.start.repository.UserRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        SecurityContextHolder.clearContext();
    }


    @Test
    public void successFindById() {
        User user = new User();
        user.setId(1L);

        when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        Assert.assertNotNull(userService.findById(1L));
        verify(userRepo,Mockito.times(1)).findById(1L);
    }

    @Test
    public void successSaveUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setPassword("12345");

        UserDto userDto = new UserDto();
        userDto.setUsername("user");
        userDto.setPassword("12345");

        when(userRepo.save(user)).thenReturn(mock(User.class));

        Assert.assertNotNull(userService.save(userDto));

        verify(userRepo,times(1)).save(any());
        verify(passwordEncoder,times(1)).encode(anyString());


    }
}