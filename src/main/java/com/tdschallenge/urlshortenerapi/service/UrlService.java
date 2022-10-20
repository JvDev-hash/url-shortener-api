package com.tdschallenge.urlshortenerapi.service;

import org.springframework.stereotype.Service;

import com.tdschallenge.urlshortenerapi.dto.UrlLongRequest;
import com.tdschallenge.urlshortenerapi.entity.Url;
import com.tdschallenge.urlshortenerapi.repository.UrlRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ConversionBase conversion;

    public UrlService(UrlRepository urlRepository, ConversionBase baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(UrlLongRequest request) {
        var url = new Url();
        url.setLongUrl(request.getLongUrl());
        url.setAccessQtd(0);
        url.setCreatedDate(new Date());
        var entity = urlRepository.save(url);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        entity.setAccessQtd(entity.getAccessQtd() + 1);
        urlRepository.save(entity);

        return entity.getLongUrl();
    }

    public String convertToShortUrl(Long id){
        return conversion.encode(id);
    }

    public List<Url> getAllUrls(){
        return urlRepository.findAll();
    }
}
