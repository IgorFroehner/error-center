package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.repository.EventRepository;
import com.igor.errorcenter.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByLevel(Pageable pageable) {
        return null;
    }
}
