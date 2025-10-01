package com.egotting.egotting.encurtadorurl.controller;

import com.egotting.egotting.encurtadorurl.domain.model.DTOs.request.UrlRequest;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IShortenerManager;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/shortener")
public class ShortenerController {
    private final IShortenerManager _service;

    public ShortenerController(IShortenerManager service) {
        _service = service;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody UrlRequest body) {
        var url = body.url();
        var response = _service.shortener(url);
        return ResponseEntity.ok().body(response);
    }
}
