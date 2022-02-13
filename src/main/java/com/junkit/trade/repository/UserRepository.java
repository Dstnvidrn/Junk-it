package com.junkit.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junkit.trade.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	

}
