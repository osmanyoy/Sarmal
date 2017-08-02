package com.example.demo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix="siemens.conf",ignoreInvalidFields = false)
public class Properties {
    @NotNull
    @Size(min = 2,max = 30)
    private String name;
    @NotBlank
    private String server;
    @Min(1024)
    @Max(65535)
    private int port;
    private List<String> strList;
    private Map<String,String> mapValues;

    private MyProp prop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, String> getMapValues() {
        return mapValues;
    }

    public void setMapValues(Map<String, String> mapValues) {
        this.mapValues = mapValues;
    }

    public MyProp getProp() {
        return prop;
    }

    public void setProp(MyProp prop) {
        this.prop = prop;
    }
}
