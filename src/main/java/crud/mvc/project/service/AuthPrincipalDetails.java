package crud.mvc.project.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface AuthPrincipalDetails {
    long getId();
    List<GrantedAuthority> getRoles();
}
