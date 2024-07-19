package com.modakbul.domain.chat.chatroom.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modakbul.domain.chat.chatroom.dto.CreateOneToOneChatReqDto;
import com.modakbul.domain.chat.chatroom.dto.GetOneToOneResDto;
import com.modakbul.domain.chat.chatroom.service.ChatRoomService;
import com.modakbul.domain.user.entity.User;
import com.modakbul.global.common.response.BaseException;
import com.modakbul.global.common.response.BaseResponse;
import com.modakbul.global.common.response.BaseResponseStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {
	private final ChatRoomService chatRoomService;

	// 채팅방 생성
	@PostMapping("/chatroom")
	public BaseResponse<GetOneToOneResDto> createOneToOneChatRoom(
		@RequestBody CreateOneToOneChatReqDto createOneToOneChatReqDto,
		@AuthenticationPrincipal User user
	) {
		// 상대방 ID 와 내 ID가 같은 경우 오류
		if (createOneToOneChatReqDto.getTheOtherUserId() == user.getId())
			throw new BaseException(BaseResponseStatus.USER_CANNOT_MAKE_CHATROOM_ALONE);

		GetOneToOneResDto getOneToOneResDto = chatRoomService.createChatRoom(createOneToOneChatReqDto, user);
		return new BaseResponse<>(getOneToOneResDto);
	}
}
