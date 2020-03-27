package com.start.integrationTesting.smoke;

import com.start.controller.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class SmokeTest extends AbstractSmokeTest{

    @Autowired
    private  UserController userController;

    @Test
    public void userControllerIsNotNull() {
        assertThat(userController).isNotNull();
    }

}
