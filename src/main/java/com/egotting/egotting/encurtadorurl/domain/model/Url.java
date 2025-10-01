package com.egotting.egotting.encurtadorurl.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Url {
    public Url(String url, String shortener_url, LocalDateTime expire_at) {
        this.url = url;
        this.shortener_url = shortener_url;
        this.expire_at = expire_at;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String shortener_url;
    @Column(nullable = false)
    private LocalDateTime expire_at;
};
