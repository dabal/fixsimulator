package com.github.dabal.fixsimulator;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;

@Component
public class FixAppConfigurationManager {
    private String fixConfiguration;


    public FixAppConfigurationManager() {
        fixConfiguration="[default]\n" +

        "SocketReuseAddress=Y\n"+
            "ResetOnLogon=Y\n"+
        "ResetOnLogout=Y\n"+
        "ResetOnDisconnect=Y\n"+
                "FileStorePath=/tmp/\n" +
                "CheckLatency=N\n" +
                "FileLogPath=/tmp/\n" +
                "ConnectionType=acceptor\n" +
                "SocketAcceptPort=9876\n" +
                "StartTime=00:00:00\n" +
                "EndTime=00:00:00\n" +
                "HeartBtInt=30\n" +
                "ValidOrderTypes=1,2,F\n" +
                "SenderCompID=*\n" +
                "TargetCompID=*\n" +
                "UseDataDictionary=Y\n" +
                "DefaultMarketPrice=15\n" +
                "\n" +
                "[session]\n" +
                "AcceptorTemplate=Y\n" +
                "DataDictionary=FIX44_RFQ_MM.xml\n" +
                "BeginString=FIX.4.4";

    }

    public String getFixConfiguration(){
        return fixConfiguration;
    }
}
