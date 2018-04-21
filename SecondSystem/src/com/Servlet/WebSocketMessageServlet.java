package com.Servlet;


import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.Tool.WebSocketTool;


@ServerEndpoint(value = "/websocket/{userId}/{username}")
public class WebSocketMessageServlet {
    private Session session;  
    private static final Logger sysLogger = Logger.getLogger("sysLog"); 
    
      
    @OnOpen  
    public void open(Session session,  @PathParam("userId")String userId,@PathParam("username")String username) {  
        this.session = session;  
        System.out.println("open:");
        sysLogger.info("*** WebSocket opened from sessionId " + WebSocketTool.getKey(userId, username));
        WebSocketTool.put(userId, username, session);
        try {
			session.getBasicRemote().sendText("server get your message from open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
      
    @OnMessage  
    public String onMessage(@PathParam("userId") String userId,  
            @PathParam("username") int username,String message) {  
    	System.out.println("onmessage:");
        sysLogger.info("*** WebSocket Received from sessionId " + this.session.getId() + ": " + message);  
        return "Got your message (" + message + ").Thanks !";
    }  
    /** 
     * 异常时触发 
     * @param userId 
     * @param username 
     * @param session 
     */  
    @OnError  
    public void onError(@PathParam("userId") String userId,  
                        @PathParam("username") String username,  
                        Throwable throwable,  
                        Session session) {  
    	sysLogger.info("Websocket Connection Exception: " + WebSocketTool.getKey(userId, username));  
    	sysLogger.info(throwable.getMessage());
    	System.out.println("连接错误:"+throwable.getMessage()); 
        WebSocketTool.remove(userId, username);  
    }
    @OnClose  
    public void end(Session session,  @PathParam("userId")String userId,@PathParam("username")String username) {  
    	sysLogger.info("Websocket Close Connection: " + WebSocketTool.getKey(userId, username)); 
    	System.out.println("end:");
    	 WebSocketTool.remove(userId, username);  
    } 



}
