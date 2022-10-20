package com.tdschallenge.urlshortenerapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlLongResponse {

    private String shortUrl;

    private Integer accessQtd;
}
