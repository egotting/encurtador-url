package com.egotting.egotting.encurtadorurl.domain.repositories.Interface;

import com.egotting.egotting.encurtadorurl.domain.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IShortenerJpaRepository extends JpaRepository<Url, Long> {
    @Query("SELECT u FROM Url u WHERE u.shortener_url = :shortUrl")
    Optional<Url> findByShortedUrl(@Param("shortUrl") String shortUrl);

}
