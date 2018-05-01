package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-30 12:47:49)
 */
@SpringBootApplication
public class SpringSecurityJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityJwtApplication.class, args);
  }

  /*@Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }*/
}
