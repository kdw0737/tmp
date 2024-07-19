package com.modakbul.domain.chat.chatroom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modakbul.domain.chat.chatroom.entity.ChatRoom;
import com.modakbul.domain.chat.chatroom.enums.ChatRoomStatus;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
	Optional<ChatRoom> findByRoomHashCodeAndChatRoomStatus(int hashCode, ChatRoomStatus chatRoomStatus);
}
