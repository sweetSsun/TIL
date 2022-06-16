package com.spring_movie01.testWebSocket;

import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestWebSocket extends TextWebSocketHandler{
	
	private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 접속 됐을 때 호출				// 접속한 클라이언트의 세션값을 저장
		System.out.println("afterConnectionEstablished() 호출");
		System.out.println("session.getId() : " + session.getId());
		sessionList.add(session);
		System.out.println("sessionList.size() : " + sessionList.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 접속 끊어졌을 때 호출
		System.out.println("afterConnectionClosed() 호출");
		System.out.println("session.getId() : " + session.getId());
		sessionList.remove(session);
		System.out.println("sessionList.size() : " + sessionList.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 접속 중인 클라이언트가 서버로 데이터를 보냈을 때 호출
		System.out.println("handleTextMessage() 호출");
		System.out.println("session.getId() : " + session.getId());
		System.out.println("message.getPayload() : " + message.getPayload());
		// getPayload : 클라이언트로부터 전달받은 데이터(message)를 스트링으로 출력
		for(int i = 0; i < sessionList.size(); i++) {
			if( !sessionList.get(i).getId().equals(session.getId()) ) {
				sessionList.get(i).sendMessage( new TextMessage( message.getPayload() ) );
			}
		}
		
		
		
	}
	
}
