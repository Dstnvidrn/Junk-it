package com.junkit.trade.service;

import com.junkit.trade.domain.Authorities;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.AuthoritiesRepository;
import com.junkit.trade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void createUserAccount(User user) {
		Authorities authority = new Authorities();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);

		String securedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(securedPassword);
		userRepository.save(user);
		authoritiesRepository.save(authority);
	}

	public User findById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User save(User user){
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		User user = findByUsername(username);
		return user;
	}

}
