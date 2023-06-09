package crud.mvc.project.config;

import crud.mvc.project.service.impl.CashDeskUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CashDeskUserDetailsService cashDeskUserDetailsService;

    public SecurityConfig(CashDeskUserDetailsService cashDeskUserDetailsService) {
        this.cashDeskUserDetailsService = cashDeskUserDetailsService;
    }

    private static final String[] SWAGGER_ENDPOINTS = {
            // -- swagger ui
            "/v2/api-docs",
            "/configuration/ui/**",
            "/swagger-resources/**",
            "/configuration/security/**",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(cashDeskUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login", "/css/**", "/js/**").permitAll()
                    .antMatchers(SWAGGER_ENDPOINTS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
