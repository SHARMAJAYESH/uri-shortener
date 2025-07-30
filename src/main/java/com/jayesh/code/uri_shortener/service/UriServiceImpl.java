package com.jayesh.code.uri_shortener.service;

import com.jayesh.code.uri_shortener.Exception.ResourceNotFoundException;
import com.jayesh.code.uri_shortener.entity.Url;
import com.jayesh.code.uri_shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UriServiceImpl implements UriService {

    private final UrlShortenerService urlShortenerService;
    private final UrlRepository urlRepository;
    private final String BASE_URL = "http://short.url/";

    @Override
    public String getShortUrl(String originalUrl) {
        if(urlRepository.existsByOriginalUrl(originalUrl))
            return BASE_URL + urlRepository.findShortUrlByOriginalUrl(originalUrl).get();
        String shortUrl = urlShortenerService.getShortUrl(originalUrl);
        Url newUrl = new Url();
        newUrl.setOriginalUrl(originalUrl);
        newUrl.setShortUrl(shortUrl);
        urlRepository.save(newUrl);
        return BASE_URL + shortUrl;
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        Optional<String> uri = urlRepository.findOriginalUrlByShortUrl(shortUrl);
        return uri.orElse(null);
    }
}
