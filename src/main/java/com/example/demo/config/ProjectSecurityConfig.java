package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig  {

    // default security
    @Bean
    SecurityFilterChain  defaultSecurityFilterChain(HttpSecurity http) throws  Exception{

        http.authorizeHttpRequests((requests)->
                requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }


    /*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    */


   // @Bean
   // public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        /**
         * Approach 1 Where we use with DefaultPasswordEncoder() Method
         * while creating the user details
         */

        /*

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .authorities("read")
                .build();  */

        /**
         *  Approach 2 where we use NoOpPasswordEncoder  Bean while creating the user details

        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();


        return new InMemoryUserDetailsManager(admin,user);
         */
    //}


    /**
     *
     * NoOpPasswordEncoder is not recommended for production usage.
     * Use only for non-prod.
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
