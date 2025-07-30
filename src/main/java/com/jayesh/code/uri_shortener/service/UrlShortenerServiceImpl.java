package com.jayesh.code.uri_shortener.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final AtomicLong idGenerator = new AtomicLong(1);
    private final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Override
    public String getShortUrl(String originalUrl) {
        long id = idGenerator.getAndIncrement();
        return encodeBase62(id);
    }

    private String encodeBase62(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62.charAt((int) (id % 62)));
            id /= 62;
        }
        return sb.toString();
    }
}
