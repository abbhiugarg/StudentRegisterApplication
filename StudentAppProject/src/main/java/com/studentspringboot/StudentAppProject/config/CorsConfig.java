package com.studentspringboot.StudentAppProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 @Configuration
 public class CorsConfig implements WebMvcConfigurer {

     @Override
     public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
                 .allowedOrigins("http://127.0.0.1:5500") // Specify your frontend origin here
                 .allowedMethods("GET", "POST", "PUT", "DELETE")
                 .allowCredentials(true);
     }

     // @Bean
     // public UserDetailsManager userDetailsManager(DataSource dataSource){
        
     //     JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
     //     jdbcUserDetailsManager.setUsersByUsernameQuery(
     //             "select user_id,pw,active from members where user_id=?");
     //     jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
     //             "select user_id,role from roles where user_id=?");
     //     return jdbcUserDetailsManager;
     // }

     // @Bean
     // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
     //     http.authorizeHttpRequests(configurer ->
     //             configurer
     //                     .requestMatchers(HttpMethod.GET,"/students").hasRole("EMPLOYEE")
     //                     .requestMatchers(HttpMethod.GET,"/students/**").hasRole("EMPLOYEE")
     //                     .requestMatchers(HttpMethod.POST,"/students").hasRole("MANAGER")
     //                     .requestMatchers(HttpMethod.PUT,"/students").hasRole("MANAGER")
     //                     .requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN"));

     //             http.httpBasic(Customizer.withDefaults());

     //             // http.csrf(csrf -> csrf.disable());

     //             return http.build();
     // }
 }

