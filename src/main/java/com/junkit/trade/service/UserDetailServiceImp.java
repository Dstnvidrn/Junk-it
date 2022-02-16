package com.junkit.trade.service;


import com.junkit.trade.domain.User;
import com.junkit.trade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username and/or pasword are incorrect");
        }
        return new SecurityUser(user);
    }
}
