package crud.mvc.project.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class AuthPrincipalDetailsImpl implements AuthPrincipalDetails {
    private long id;
    private List<GrantedAuthority> roles;

    public AuthPrincipalDetailsImpl(long id, List<GrantedAuthority> roles) {
        this.id = id;
        this.roles = roles;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public List<GrantedAuthority> getRoles() {
        return roles;
    }
}
