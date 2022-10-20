package com.tdschallenge.urlshortenerapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlShortResponse {

    private String shortUrl;

    private String createdDate;
}
