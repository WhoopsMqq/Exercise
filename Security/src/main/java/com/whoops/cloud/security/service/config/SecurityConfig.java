package com.whoops.cloud.security.service.config;

import com.whoops.cloud.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new NoEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/security/login")
            .failureUrl("/security/login-error")
            .successForwardUrl("/success")
            .loginProcessingUrl("/login-in")
            .and()
            .authorizeRequests()
            .antMatchers("/app/**", "/mobile/**", "/code/*", "/docking/*",
                    "/logout", "/login-in", "/pass/**", "/retrieve/**", "/mobileGuestIndex",
                    "/css/**", "/fonts/**", "/pay/**", "/images/**", "/js/**", "/json/**","/login","/login-in").permitAll()
            .anyRequest().authenticated()
            .and()
            .headers().frameOptions().disable()
            .and().exceptionHandling().accessDeniedPage("/403")//异常处理拒绝访问就重定向到403页面
//            .and().csrf().ignoringAntMatchers("/pass/**", "/docking/**", "/upload/**", "/app/**","/login-in")
            .and().csrf().disable()
        ;

    }


}
