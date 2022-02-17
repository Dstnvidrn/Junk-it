package com.junkit.trade.service;

import com.junkit.trade.domain.Authorities;
import com.junkit.trade.domain.Message;
import com.junkit.trade.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junkit.trade.domain.User;
import com.junkit.trade.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	public User save(User user) {
		Authorities authority = new Authorities();

		return userRepository.save(user);
	}

	public User findById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
