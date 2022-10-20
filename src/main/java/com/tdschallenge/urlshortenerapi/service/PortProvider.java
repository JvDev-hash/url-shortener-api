package com.tdschallenge.urlshortenerapi.service;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PortProvider implements ApplicationListener<ServletWebServerInitializedEvent > {

    private Integer thePort;

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        setThePort(event.getWebServer().getPort());
    }
}
