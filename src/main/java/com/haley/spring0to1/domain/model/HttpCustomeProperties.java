package com.haley.spring0to1.domain.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "http", ignoreUnknownFields = false)
@PropertySource("classpath:config/http.properties")
public class HttpCustomeProperties {

    private int timeout;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void show() {
        System.out.println("timeout:" + this.timeout);
    }
}
