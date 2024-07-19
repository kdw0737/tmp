package com.modakbul.domain.chat.chatroom.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.modakbul.domain.chat.chatroom.repository.ChatRoomRepository;
import com.modakbul.domain.user.entity.User;
import com.modakbul.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

	private final ChatRoomRepository chatRoomRepository;
	private final UserRepository userRepository;

	//    @Transactional
	//    public BaseResponse<GetOneToOneResDto> createChatRoom(CreateOneToOneChatReqDto reqDto, User user) {
	//        // 상대방 조회
	//        User theOtherUser = userRepository.findByIdAndUserStatus(user.getId(), UserStatus.ACTIVE)
	//                .orElseThrow(() -> new BaseException(BaseResponseStatus.ID_NOT_EXIST));
	//
	//        // 채팅방 해시코드 생성
	//        int roomHashCode = createRoomHashCode(user, theOtherUser);
	//
	//        // 방 존재 여부 조회
	//        if(existRoom(roomHashCode, user, theOtherUser)) {
	//            ChatRoom savedChatRoom = chatRoomRepository.findByRoomHashCodeAndChatRoomStatus(roomHashCode, ChatRoomStatus.ACTIVE)
	//                    .orElseThrow(() -> new BaseException(BaseResponseStatus.CHATROOM_NOT_FOUND));
	//        }
	//    }

	// 채팅방 해시코드 생성
	private int createRoomHashCode(User user, User anotherUser) {
		Long userId = user.getId();
		Long anotherId = anotherUser.getId();
		return userId > anotherId ? Objects.hash(userId, anotherId) : Objects.hash(anotherId, userId);
	}

}
