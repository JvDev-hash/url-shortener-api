package com.tdschallenge.urlshortenerapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdschallenge.urlshortenerapi.dto.UrlLongRequest;
import com.tdschallenge.urlshortenerapi.dto.UrlLongResponse;
import com.tdschallenge.urlshortenerapi.dto.UrlShortResponse;
import com.tdschallenge.urlshortenerapi.entity.Url;
import com.tdschallenge.urlshortenerapi.service.UrlService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shortener")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("create-short")
    public UrlShortResponse convertToShortUrl(@RequestBody UrlLongRequest request) {
        var urlResponse = new UrlShortResponse();
        var shortUrl = urlService.convertToShortUrl(request);

        urlResponse.setShortUrl("/shortener/" + shortUrl);
        urlResponse.setCreatedDate(getActualDate());
        return urlResponse;
    }

    @GetMapping(value = "{shortUrl}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        var url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @DeleteMapping(value = "{shortUrl}")
    public ResponseEntity<Void> deleteUrl(@PathVariable String shortUrl){
        urlService.deleteUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "statistics")
    public List<UrlLongResponse> getAccessQtds() {
        var UrlsList = urlService.getAllUrls();
        var responseList = new ArrayList<UrlLongResponse>();

        for(Url url : UrlsList){
            var tempResponse = new UrlLongResponse();
            tempResponse.setShortUrl("/shortener/" + urlService.convertToShortUrl(url.getId()));
            tempResponse.setAccessQtd(url.getAccessQtd());
            responseList.add(tempResponse);
        }

        return responseList;
    }

    private String getActualDate(){
        String pattern = "MM-dd-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}
