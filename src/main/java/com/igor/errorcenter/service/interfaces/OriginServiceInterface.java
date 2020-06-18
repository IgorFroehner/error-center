package com.igor.errorcenter.service.interfaces;

import com.igor.errorcenter.entity.Origin;

public interface OriginServiceInterface{

    Origin save(Origin origin);

    Origin update(Origin origin);

    void delete(Long id);

    Origin findById(Long id);

    Origin findByLogin(String login);

}
