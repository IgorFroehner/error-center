package com.igor.errorcenter.service.interfaces;

import com.igor.errorcenter.entity.Origin;

import java.util.List;

public interface OriginServiceInterface{

    Origin save(Origin origin);

    Origin update(Origin origin);

    void delete(Long id);

    Origin findById(Long id);

    List<Origin> findByLogin(String login);

}
