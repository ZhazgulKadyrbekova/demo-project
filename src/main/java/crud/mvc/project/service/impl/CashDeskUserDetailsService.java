package crud.mvc.project.service.impl;

import crud.mvc.project.entity.CashDeskAuth;
import crud.mvc.project.service.CashDeskAuthEntityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashDeskUserDetailsService implements UserDetailsService {

    private final CashDeskAuthEntityService entityService;

    public CashDeskUserDetailsService(CashDeskAuthEntityService entityService) {
        this.entityService = entityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CashDeskAuth cashDeskAuth = entityService.findByUsername(username);
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(cashDeskAuth.getRole().name()));
        return new User(cashDeskAuth.getUsername(), cashDeskAuth.getPassword(), roles);
    }
}
