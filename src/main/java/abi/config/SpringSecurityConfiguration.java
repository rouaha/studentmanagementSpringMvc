package abi.config;

import abi.controller.StudentController;
import abi.repository.UserRepo;
import abi.repository.UserRepository;
import abi.service.CustomerService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by BS190 on 7/9/2017.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableJpaRepositories(basePackageClasses = UserRepo.class)
@EnableWebSecurity

public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomerService  getCustomerService() {
        return  new CustomerService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getCustomerService());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID").
                logoutUrl("/logout")
                //.logoutRequestMatcher(
                     //   new AntPathRequestMatcher("/login?logout"))

               .logoutSuccessUrl("/login");
                //.logoutSuccessHandler(logoutCustomHandler());
    }
   // @Bean
    //LogoutSuccessHandler logoutCustomHandler(){
       // return  new CustomLogoutSuccessHandler();
   // }


}
