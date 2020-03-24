package com.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
 other beans, and various property settings.

 @EnableWebMvc: Flags the application as a web application and activates key behaviors,
  such as setting up a DispatcherServlet.
  Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
*/


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
