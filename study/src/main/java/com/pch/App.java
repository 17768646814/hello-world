package com.pch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
//        springApplication.addListeners();
        springApplication.run(args);
    }
}
