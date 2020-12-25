package com.danielsedoff.college.schedule.config;

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

import com.danielsedoff.college.schedule.model.Permission;

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

                .antMatchers("/courseForm")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/groupForm")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/lessonForm")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/professorForm")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/studentForm")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers("/courseList")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/groupList")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/lessonList")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/professorList")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers("/studentList")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers("/create*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers("/delete*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers("/update*")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.GET, "/courses/**")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/lessons/**")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/groups/**")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/professors/**")
                .hasAuthority(Permission.DATA_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/students/**")
                .hasAuthority(Permission.DATA_READ.getPermission())

                .antMatchers(HttpMethod.POST, "/courses/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/lessons/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/groups/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/professors/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/students/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.PUT, "/courses/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/lessons/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/groups/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/professors/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/students/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())

                .antMatchers(HttpMethod.DELETE, "/courses/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/lessons/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/groups/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/professors/**")
                .hasAuthority(Permission.DATA_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/students/**")
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
