package com.tdschallenge.urlshortenerapi.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "url")
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private Date createdDate;

    private Integer accessQtd;
}

