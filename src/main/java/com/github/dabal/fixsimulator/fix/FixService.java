package com.github.dabal.fixsimulator.fix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quickfix.*;
import quickfix.fix44.MessageCracker;

@Service
@Slf4j
public class FixService extends MessageCracker implements Application {

    @Override
    public void onCreate(SessionID sessionId) {
        log.debug("onCreate; sessionId: " + sessionId.toString());
    }

    @Override
    public void onLogon(SessionID sessionId) {
        log.debug("onLogon; sessionId: " + sessionId.toString());


    }

    @Override
    public void onLogout(SessionID sessionId) {
        log.debug("onLogout; sessionId: " + sessionId.toString());

    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        log.info(String.format("%s - %s - %s", sessionId.toString(), "toAdmin", message.toString()));

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.info(String.format("%s - %s - %s", sessionId.toString(), "fromAdmin", message.toRawString()));
    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {
        log.info(String.format("%s - %s - %s", sessionId.toString(), "toApp", message.toString()));
    }

    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.info(String.format("%s - %s - %s", sessionId.toString(), "fromApp", message.toRawString()));


    }
}
