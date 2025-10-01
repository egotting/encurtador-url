package com.egotting.egotting.encurtadorurl.domain.repositories.Interface;

import com.egotting.egotting.encurtadorurl.domain.model.Url;

import java.io.IOException;
import java.util.Optional;

public interface IShortenerRepository {
    Optional<Url> findByShortedUrl(String url);

    String create(String url, String generate);

}
