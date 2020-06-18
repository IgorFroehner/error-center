package com.igor.errorcenter.repository;

import com.igor.errorcenter.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Long> {

    Origin save(Origin origin);

    @Override
    void delete(Origin origin);

    @Override
    Optional<Origin> findById(Long aLong);

    Optional<Origin> findByLogin(String login);

}
