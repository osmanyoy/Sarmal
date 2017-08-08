package com.trainig.spring;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement
public class AppProp {
    private String serverName;
    private String connectionIP;
    private int port;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getConnectionIP() {
        return connectionIP;
    }

    public void setConnectionIP(String connectionIP) {
        this.connectionIP = connectionIP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AppProp{" + "serverName='" + serverName + '\'' + ", connectionIP='" + connectionIP + '\'' + ", port=" + port + '}';
    }
}
