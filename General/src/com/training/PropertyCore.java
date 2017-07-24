package com.training;

/**
 * Created by Osman on 24.07.2017.
 */
@PropertySource(fileName = "core.properties")
public class PropertyCore {
    @PropertyItem(key = "core.timeout")
    private long requestTimeout;

    @PropertyItem(key = "core.application.name")
    private String applicationName;

    public long getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(long requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
