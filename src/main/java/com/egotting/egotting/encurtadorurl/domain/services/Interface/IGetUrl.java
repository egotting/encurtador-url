package com.egotting.egotting.encurtadorurl.domain.services.Interface;

import com.egotting.egotting.encurtadorurl.domain.model.Url;

import java.util.Optional;

public interface IGetUrl {

    Optional<Url> getShorted(String url);
}
