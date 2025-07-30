package com.jayesh.code.uri_shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String shortUrl;
    private String originalUrl;
}
