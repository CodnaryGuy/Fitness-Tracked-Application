//package com.codna.fitness.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity // to secure the method level endpoints
//public class SecurityConfigDemo {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    AuthTokenFilter authTokenFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http){
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorizeRequests ->
//                authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                                .requestMatchers("/signin").permitAll()
//                        .anyRequest().authenticated());
////        http.httpBasic(Customizer.withDefaults());
//        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userOne = User.withUsername("user1")
////                .password("{noop}password1")
//                .password(passwordEncoder().encode("password1"))
//                .build();
//
//        UserDetails userTwo = User.withUsername("user2")
//                .password("{noop}password2")
//                .roles("USER")  // ROLE_USER
//                .build();
//
//        UserDetails admin = User.withUsername("user3")
//                .password("{noop}password3")
//                .roles("ADMIN")  // ROLE_ADMIN
//                .build();
//
////        return new InMemoryUserDetailsManager(userOne);
//        JdbcUserDetailsManager userDetailsManager = new
//                JdbcUserDetailsManager(dataSource);
//
//        if(!userDetailsManager.userExists(userOne.getUsername())){
//            userDetailsManager.createUser(userOne);
//        }
//        if(!userDetailsManager.userExists(userTwo.getUsername())){
//            userDetailsManager.createUser(userTwo);
//        }
//        if(!userDetailsManager.userExists(admin.getUsername())){
//            userDetailsManager.createUser(admin);
//        }
//
//        return userDetailsManager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder){
//        return builder.getAuthenticationManager();
//    }
//
//}
