package crud.mvc.project.config;

import crud.mvc.project.service.impl.CashDeskUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CashDeskUserDetailsService cashDeskUserDetailsService;

    public SecurityConfiguration(CashDeskUserDetailsService cashDeskUserDetailsService) {
        this.cashDeskUserDetailsService = cashDeskUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .userDetailsService(cashDeskUserDetailsService)
                .authorizeRequests()
                    .antMatchers("/login", "/css/**", "/js/**").permitAll()
                    .antMatchers("/actuator/**").permitAll()
                    .antMatchers("/api-docs/**").permitAll()
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
        return httpSecurity.build();
    }
}