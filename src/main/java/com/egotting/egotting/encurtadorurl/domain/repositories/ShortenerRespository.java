package com.egotting.egotting.encurtadorurl.domain.repositories;

import com.egotting.egotting.encurtadorurl.domain.model.Url;
import com.egotting.egotting.encurtadorurl.domain.repositories.Interface.IShortenerJpaRepository;
import com.egotting.egotting.encurtadorurl.domain.repositories.Interface.IShortenerRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class ShortenerRespository implements IShortenerRepository {
    private final IShortenerJpaRepository _repo;

    public ShortenerRespository(IShortenerJpaRepository repo) {
        _repo = repo;
    }

    @Override
    public Optional<Url> findByShortedUrl(String shorted) {
        return _repo.findByShortedUrl(shorted);
    }

    @Override
    public String create(String original_url, String generate) {
        Url url = new Url();
        url.setUrl(original_url);
        url.setShortener_url(generate);
        url.setExpire_at(LocalDateTime.now().plusDays(1));

        _repo.save(url);
        return url.getShortener_url();
    }
}
