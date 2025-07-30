package com.jayesh.code.uri_shortener.service;

import org.springframework.stereotype.Service;

public interface UriService {
    String getShortUrl(String originalUrl);
    String getOriginalUrl(String shortUrl);
}
