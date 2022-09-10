package com.spring_movie01.testWebSocket;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

public class ChatWebSocket extends TextWebSocketHandler{

	private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished() 호출");
		System.out.println("session.getId() : " + session.getId());
		sessionList.add(session);
		
		/*
		 * 접속중인 회원 출력을 위한 코드
		Map<String, Object> connectMap = session.getAttributes();
		String loginId = (String)connectMap.get("loginId");
		if(loginId == null) {
			loginId = "비회원_"+session.getId();
		} else {
			loginId = session.getId();
		}
		Gson gson = new Gson();
		ChatMsgDto chatdto = new ChatMsgDto();
		chatdto.setMsgUserId(loginId);
		chatdto.setMsgComment("connect"); // ????
		for (int i = 0; i < sessionList.size(); i++) {
			if (!sessionList.get(i).getId().equals(session.getId())) {
				sessionList.get(i).sendMessage(new TextMessage(gson.toJson(chatdto)));
			}
		}
		*/
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed() 호출");
		System.out.println("session.getId() : " + session.getId());
		sessionList.remove(session);
		
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage() 호출");
		System.out.println("session.getId() : " + session.getId());
		System.out.println("message.getPayload() : " + message.getPayload());
		
		Gson gson = new Gson();
		ChatMsgDto chatdto = gson.fromJson(message.getPayload(), ChatMsgDto.class);
		
		if (chatdto.getMsgUserId().length() == 0) {
			chatdto.setMsgUserId("비회원_" + session.getId());
		}

		for (int i = 0; i < sessionList.size(); i++) {
			if (!sessionList.get(i).getId().equals(session.getId())) {
				sessionList.get(i).sendMessage( new TextMessage(gson.toJson(chatdto)));
			}
		}
	}


}
