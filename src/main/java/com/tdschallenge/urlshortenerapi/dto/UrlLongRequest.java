package com.tdschallenge.urlshortenerapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlLongRequest {

    private String longUrl;

    private Integer accessQtd;
}