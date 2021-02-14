package com.github.dabal.fixsimulator.fix;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quickfix.Session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service

public class FixSessionManager {

    ConcurrentMap<String, Session> sessionMap;

    @Autowired
    public FixSessionManager() {
        this.sessionMap = new ConcurrentHashMap<>();
    }


    public void addSession(String name, Session session){
        sessionMap.put(name, session);
    }



}
