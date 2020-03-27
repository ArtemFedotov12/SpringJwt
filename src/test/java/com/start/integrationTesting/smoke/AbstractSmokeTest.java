package com.start.integrationTesting.smoke;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractSmokeTest {

    @Before
    public void setUp() {
        SecurityContextHolder.clearContext();
    }

}
