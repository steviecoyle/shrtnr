package com.scoyle.shrtnr.persistence.repository;

import com.scoyle.shrtnr.persistence.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
}
