package com.aeshwer.ServerEndPoint;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverendpointdemo2")
public class ServerEndPointDemo2 {

	@OnOpen
	public void handleOpen() {
		System.out.println("Client is connected...... comming from 2");
	}

	@OnMessage
	public String handleMessage(final String message) {
		System.out.println("Message is received ......comming from 2  " + message);
		final String replyMessage = "echo :comming from 2  " + message;
		System.out.println("send to client :comming from 2  " + replyMessage);
		return replyMessage;
	}

	@OnClose
	public void handleClose() {
		System.out.println("Client is disconnected......comming from 2  ");
	}

	@OnError
	public void handleError(final Throwable e) {
		e.printStackTrace();
	}
}
