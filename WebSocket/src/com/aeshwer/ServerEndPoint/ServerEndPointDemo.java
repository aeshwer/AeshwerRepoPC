package com.aeshwer.ServerEndPoint;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverendpointdemo")
public class ServerEndPointDemo {

	@OnOpen
	public void handleOpen() {
		System.out.println("Client is connected......");
	}

	@OnMessage
	public String handleMessage(final String message) {
		System.out.println("Message is received ......" + message);
		final String replyMessage = "echo :" + message;
		System.out.println("send to client : " + replyMessage);
		return replyMessage;
	}

	@OnClose
	public void handleClose() {
		System.out.println("Client is disconnected......");
	}

	@OnError
	public void handleError(final Throwable e) {
		e.printStackTrace();
	}
}
