package com.tdschallenge.urlshortenerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tdschallenge.urlshortenerapi.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
