package com.junkit.trade.repository;

import com.junkit.trade.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junkit.trade.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    //SELECT * FROM User WHERE username = :username

    User findUserByUsername(String username);


}
