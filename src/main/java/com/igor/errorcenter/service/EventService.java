package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.repository.EventRepository;
import com.igor.errorcenter.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;


}
