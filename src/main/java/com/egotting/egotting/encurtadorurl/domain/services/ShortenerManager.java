package com.egotting.egotting.encurtadorurl.domain.services;

import com.egotting.egotting.encurtadorurl.domain.model.DTOs.request.UrlRequest;
import com.egotting.egotting.encurtadorurl.domain.model.Url;
import com.egotting.egotting.encurtadorurl.domain.repositories.Interface.IShortenerRepository;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IShortenerGenerate;
import com.egotting.egotting.encurtadorurl.domain.services.Interface.IShortenerManager;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;


@Service
public class ShortenerManager implements IShortenerManager {
    private final IShortenerRepository _repo;
    private final IShortenerGenerate _generate;

    public ShortenerManager(IShortenerRepository repo, IShortenerGenerate generate) {
        _repo = repo;
        _generate = generate;
    }

    @Override
    public String shortener(String original_url) {
        return _repo.create(original_url, _generate.generate());
    }

}
