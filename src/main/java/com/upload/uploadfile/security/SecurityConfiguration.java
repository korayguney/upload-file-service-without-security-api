package com.upload.uploadfile.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/adduser", "updateuser").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/index", true)
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("koray")
                .password("{noop}pass")
                .roles("ADMIN")
                .and()
                .withUser("ali")
                .password("{noop}pass")
                .roles("USER");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        //User Role
        UserDetails theUser = User.withUsername("sergey")
                .password("1234").roles("USER").build();

        //Admin Role
        UserDetails theManager = User.withUsername("john")
                .password("1234").roles("ADMIN").build();


        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager);

        return userDetailsManager;
    }
}
