package com.junkit.trade.repository;

import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    public List<Message> findByUser(User userId);

}
