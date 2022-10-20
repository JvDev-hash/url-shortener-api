package com.tdschallenge.urlshortenerapi;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.tdschallenge.urlshortenerapi.dto.UrlLongRequest;
import com.tdschallenge.urlshortenerapi.entity.Url;
import com.tdschallenge.urlshortenerapi.repository.UrlRepository;
import com.tdschallenge.urlshortenerapi.service.ConversionBase;
import com.tdschallenge.urlshortenerapi.service.UrlService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UrlShortenerApiApplicationTests {

    @Mock
    UrlRepository mockUrlRepository;

    @Mock
    ConversionBase mockConversionBase;

    @InjectMocks
    UrlService urlService;

    @Test
    public void convertToShortUrlTest() {
        var url = new Url();
        url.setLongUrl("https://github.com/JvDev-hash/url-shortener-api");
        url.setCreatedDate(new Date());
		url.setAccessQtd(0);
        url.setId(9);

        when(mockUrlRepository.save(any(Url.class))).thenReturn(url);
        when(mockConversionBase.encode(url.getId())).thenReturn("j");

        var urlRequest = new UrlLongRequest();
        urlRequest.setLongUrl("https://github.com/JvDev-hash/url-shortener-api");

        assertEquals("j", urlService.convertToShortUrl(urlRequest));
    }

    @Test
    public void getOriginalUrlTest() {
        when(mockConversionBase.decode("v")).thenReturn((long) 21);

        var url = new Url();
        url.setLongUrl("https://github.com/JvDev-hash/url-shortener-api");
        url.setCreatedDate(new Date());
		url.setAccessQtd(0);
        url.setId(21);

        when(mockUrlRepository.findById((long) 21)).thenReturn(java.util.Optional.of(url));
        assertEquals("https://github.com/JvDev-hash/url-shortener-api", urlService.getOriginalUrl("v"));

    }
}
