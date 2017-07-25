package com.mp.database.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
	List<Message> findById(Long id);
	List<Message> findBySenderUid(String senderUid);
	List<Message> findByReciverUid(String reciverUid);
	List<Message> findBySenderUidOrReciverUid(String senderUid, String reciverUid);
}
