package com.danielsedoff.college.schedule.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.danielsedoff.college.schedule.security.model.Permission;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(
            @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                .antMatchers("/")
                .hasAuthority(Permission.DATA_READ.getPermission())
                
                .antMatchers("/reset*")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers("/*Form")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers("/*List")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers("/create*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                
                .antMatchers("/delete*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                
                .antMatchers("/update*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.GET, "/**/**")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers(HttpMethod.POST, "/**/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.PUT, "/**/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.DELETE, "/**/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);

    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
