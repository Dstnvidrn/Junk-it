package com.junkit.trade.repository;

import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


//    @Query(nativeQuery = true, value = "SELECT * FROM message m WHERE m.receiver_user_id = :userId")


    public List<Message> findAllByReceiverUserId(Long userId);







}
