package com.egotting.egotting.encurtadorurl.controller;

import com.egotting.egotting.encurtadorurl.domain.model.Url;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IGetUrl;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IRedirectService;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping()
public class RedirectController {
    private final IGetUrl _url;
    private final IRedirectService _redirect;

    public RedirectController(
            IGetUrl url, IRedirectService redirect
    ) {
        _url = url;
        _redirect = redirect;
    }

    @GetMapping("/{short_url}")
    public RedirectView get(@PathVariable String short_url) {
        Optional<Url> shorted_url_opt = _url.getShorted(short_url);
        if (shorted_url_opt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL não encontrada");
        }
        Url shorted_url = shorted_url_opt.get();
        System.out.println(shorted_url.getUrl());
        return new RedirectView(shorted_url.getUrl());
    }
}
