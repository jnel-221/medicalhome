package teksystems.medicalhome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import teksystems.medicalhome.security.UserDetailsServiceImpl;

//primary configuration for SpringSecurity
//required annotations for security config; boilerplate
@Configuration
@EnableWebSecurity //turns on Spring Security
@EnableMethodSecurity //allows us to put security on controllers
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()//list of urls that will be un secured, anyone can access. Customize to your app
                .antMatchers("/pub/**", "/error/**", "/login/**", "/user/register","/user/registerSubmit", "/index").permitAll()//these are urls that do not require authentication(not logged in)
                .antMatchers("/admin/**", "/user/**").authenticated()//all admin functions should be in the admin folder; these are URLS that need authenticated
                .and()
                .formLogin()
                //url of login page itself, matches up to request-mapping value in controller
                .loginPage("/login/login")
                //url where login page will submit, should match value in form action attribute on jsp.
                .loginProcessingUrl("/login/loginSubmit")
                .defaultSuccessUrl("/index")//view that will display on successful login; can change this later.
                .and()
                .logout()
                .invalidateHttpSession(true)
                //url to make somebody log-out
                .logoutUrl("/login/logout")
                //url you go to when you log-out
                .logoutSuccessUrl("/index")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/404");
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }


    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

