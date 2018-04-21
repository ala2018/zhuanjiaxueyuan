package com.Tool;

import javax.websocket.Session;  
import java.util.Map;  
import java.util.concurrent.ConcurrentHashMap;  
  
 
public class WebSocketTool {  
  
    public static Map<String, Session> onlineuser = new ConcurrentHashMap<>();  
  
    public static void put(String userId, String username, Session session){  
        onlineuser.put(getKey(userId, username), session);  
    }  
  
    public static Session get(String userId, String username){  
        return onlineuser.get(getKey(userId, username));  
    }  
  
    public static void remove(String userId, String username){  
        onlineuser.remove(getKey(userId, username));  
    }  
  
    /** 
     * 判断是否有连接 
     * @param userId 
     * @param username 
     * @return 
     */  
    public static boolean hasConnection(String userId, String username) {  
        return onlineuser.containsKey(getKey(userId, username));  
    }  
  
    /** 
     * 组装唯一识别的key 
     * @param userId 
     * @param username 
     * @return 
     */  
    public static String getKey(String userId, String username) {  
        return userId + "_" + username;  
    }  
  
}
