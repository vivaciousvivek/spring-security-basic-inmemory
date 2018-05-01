package com.example.security.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration about which resource to be protected and which not can be configured
 *
 * @author VIVEK KUMAR SINGH
 * @since (2018-04-30 12:44:32)
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*authorized any request and permit all*/
    //    http.authorizeRequests().anyRequest().permitAll().and().httpBasic();

    /* Allow every request should be fully authenticated */
    http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();

    /*
     * If u want specific request to be authorized, use antMatchers
     */
    //        http.authorizeRequests().antMatchers("**/api/*").authenticated().anyRequest().permitAll().hasRole("USER").and().httpBasic();

    http.csrf().disable();
  }

  /**
   * In Memory Authentication using Http Basic Spring security
   *
   * @param auth
   * @throws Exception
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /**
     * Here we are using {noop} in password for NoopPasswordEncoder that is required onwards spring
     * 4.3.x
     */
    auth.inMemoryAuthentication()
        .withUser("vivek")
        .password("{noop}vivek")
        .roles("USER")
        .and()
        .withUser("admin")
        .password("{noop}admin")
        .roles("ADMIN");
  }
}
