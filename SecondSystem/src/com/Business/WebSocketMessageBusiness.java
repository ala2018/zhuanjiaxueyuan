package com.Business;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/Socket")
public class WebSocketMessageBusiness { 
    @OnMessage  
    public void resolveTextMessage(String message, Session session) {  
        try {  
            session.getBasicRemote().sendText("server get your message:" + message);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
} 
