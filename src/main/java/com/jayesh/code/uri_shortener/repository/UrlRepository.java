package com.jayesh.code.uri_shortener.repository;

import com.jayesh.code.uri_shortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query("SELECT u.originalUrl FROM Url u WHERE u.shortUrl = :shortUrl")
    Optional<String> findOriginalUrlByShortUrl(String shortUrl);

    boolean existsByOriginalUrl(String originalUrl);

    @Query("SELECT u.shortUrl FROM Url u WHERE u.originalUrl = :originalUrl")
    Optional<String> findShortUrlByOriginalUrl(String originalUrl);
}
