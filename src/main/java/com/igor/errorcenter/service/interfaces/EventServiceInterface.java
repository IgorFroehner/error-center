package com.igor.errorcenter.service.interfaces;


import com.igor.errorcenter.entity.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventServiceInterface{

    List<Event> findAll(Pageable pageable);

    List<Event> findByLevel(Pageable pageable);

}
