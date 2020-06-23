package com.igor.errorcenter.service.interfaces;

import com.igor.errorcenter.entity.Origin;

import java.util.Optional;

public interface OriginServiceInterface{

    Origin save(Origin origin);

    Origin update(Origin origin);

    void delete(Long id);

    Optional<Origin> findById(Long id);

    Optional<Origin> findByLogin(String login);

}
