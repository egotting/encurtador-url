package com.egotting.egotting.encurtadorurl.domain.services;

import com.egotting.egotting.encurtadorurl.domain.model.Url;
import com.egotting.egotting.encurtadorurl.domain.repositories.Interface.IShortenerRepository;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IGetUrl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUrl implements IGetUrl {
    private final IShortenerRepository _repo;

    public GetUrl(IShortenerRepository repo) {
        _repo = repo;
    }

    @Override
    public Optional<Url> getShorted(String url) {
        return _repo.findByShortedUrl(url);
    }
}
