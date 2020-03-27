package com.start.integrationTesting.security.rest;

import com.google.gson.Gson;
import com.start.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public abstract class AbstractIntegrationTest {

   @Autowired
   protected MockMvc mockMvc;
   @Autowired
   protected Gson gson;

   @Before
   public void setUp() {
      SecurityContextHolder.clearContext();
   }

}
