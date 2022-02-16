package com.junkit.trade.service;

import com.junkit.trade.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;


public class SecurityUser extends User implements UserDetails {



    public SecurityUser(User user) {
        this.setAuthorities(user.getAuthorities());
        this.setUserId(user.getUserId());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    public SecurityUser() {}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
