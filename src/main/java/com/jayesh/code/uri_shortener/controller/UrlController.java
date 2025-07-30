package com.jayesh.code.uri_shortener.controller;

import com.jayesh.code.uri_shortener.dto.RequestDto;
import com.jayesh.code.uri_shortener.dto.ResponseDto;
import com.jayesh.code.uri_shortener.service.UriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/short-url")
@RequiredArgsConstructor
public class UrlController {
    private final UriService uriService;

    private final String BASE_URL = "http://short.url/";

    @PostMapping("/shorten")
    public ResponseEntity<ResponseDto> shortenUrl(@RequestBody RequestDto urlRequest) {
        // Logic to shorten the URL
        String shortUrl = uriService.getShortUrl(urlRequest.getOriginalUrl());
        ResponseDto response = new ResponseDto(shortUrl, urlRequest.getOriginalUrl());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<ResponseDto> redirectToOriginalUrl(@PathVariable String shortUrl) {
        // Logic to redirect to the original URL
        String originalUrl = uriService.getOriginalUrl(shortUrl);
        ResponseDto response = new ResponseDto(BASE_URL+shortUrl,originalUrl);
        return ResponseEntity.ok(response);
    }
}
