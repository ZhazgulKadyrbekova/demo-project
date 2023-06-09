package crud.mvc.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
//@Order(Integer.MAX_VALUE)
public class SwaggerWebSecurityConfigurationAdapter implements WebSecurityCustomizer {
    private static final String[] SWAGGER_ENDPOINTS = {
                // -- swagger ui
            "/v2/api-docs",
            "/configuration/ui/**",
            "/swagger-resources/**",
            "/configuration/security/**",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

    @Override
    public void customize(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(SWAGGER_ENDPOINTS);
    }

    public void configure(WebSecurity web) {
            web
                .ignoring()
                .antMatchers(SWAGGER_ENDPOINTS);
        }
}
