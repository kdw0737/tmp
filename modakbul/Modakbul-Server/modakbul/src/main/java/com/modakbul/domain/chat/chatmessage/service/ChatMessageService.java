package com.modakbul.domain.chat.chatmessage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modakbul.domain.chat.chatmessage.repository.ChatMessageRepository;
import com.modakbul.domain.chat.chatroom.entity.ChatRoom;
import com.modakbul.domain.chat.chatroom.repository.ChatRoomRepository;
import com.modakbul.domain.user.entity.User;
import com.modakbul.domain.user.repository.UserRepository;
import com.modakbul.global.common.response.BaseException;
import com.modakbul.global.common.response.BaseResponseStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatMessageService {

	private final UserRepository userRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final ChatMessageRepository chatMessageRepository;

	//-- 채팅방 입장 --//
	public void enter(ChatMessageReqDto chatMessageReqDto) {
		User findUser = userRepository.findById(chatMessageReqDto.getSenderId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.ID_NOT_EXIST));
		ChatRoom findChatRoom = chatRoomRepository.findById(chatMessageReqDto.getChatRoomId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.CHATROOM_NOT_FOUND));
	}
}
