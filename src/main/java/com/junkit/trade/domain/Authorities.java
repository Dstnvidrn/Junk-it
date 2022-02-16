package com.junkit.trade.domain;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Authorities implements GrantedAuthority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String authority;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;

    @Override
    public String getAuthority() {
        return authority;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
