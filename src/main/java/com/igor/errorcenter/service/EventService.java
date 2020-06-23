package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.entity.Origin;
import com.igor.errorcenter.repository.EventRepository;
import com.igor.errorcenter.repository.OriginRepository;
import com.igor.errorcenter.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OriginRepository originRepository;

    @Override
    public List<Event> findAll(Pageable pageable) {
        return this.eventRepository.findAll(pageable).getContent();
    }

    @Override
    public Event save(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public Event update(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public void delete(Long id) {
        Event event = this.eventRepository.findById(id).get();
        this.eventRepository.delete(event);
    }

    @Override
    public List<Event> findByLevel(String strLevel, Pageable pageable) {
        Level level = setLevel(strLevel);
        return this.eventRepository.findByLevel(level, pageable).getContent();
    }

    @Override
    public List<Event> findByEventDescription(String eventDescription, Pageable pageable) {
        return this.eventRepository.findByEventDescription(eventDescription, pageable).getContent();
    }

    @Override
    public List<Event> findByOrigin(Long idOrigin, Pageable pageable) {
        Origin origin = this.originRepository.findById(idOrigin).get();
        return this.eventRepository.findByOrigin(origin, pageable).getContent();
    }

    @Override
    public List<Event> findByEventLog(String log, Pageable pageable) {
        return this.eventRepository.findByEventLog(log, pageable).getContent();
    }

    @Override
    public List<Event> findByLevelAndDateAndOrigin(String level,
                                                   Date date,
                                                   Long idOrigin,
                                                   Pageable pageable) {
        Origin origin = this.originRepository.findById(idOrigin).get();
        return this.eventRepository.findByLevelAndCreatedAtAndOrigin(setLevel(level),date, origin, pageable).getContent();
    }

    @Override
    public List<Event> findByOriginAndDate(Long idOrigin, Date date, Pageable pageable) {
        Origin origin = this.originRepository.findById(idOrigin).get();
        return this.eventRepository.findByOriginAndCreatedAt(origin, date, pageable).getContent();
    }

    @Override
    public List<Event> findByCreatedAt(Date date, Pageable pageable) {
        return this.eventRepository.findByCreatedAt(date, pageable).getContent();
    }

    @Override
    public List<Event> findByLevelAndDate(String level, Date date, Pageable pageable) {
        return this.eventRepository.findByLevelAndCreatedAt(setLevel(level), date, pageable).getContent();
    }

    private Level setLevel(String strLevel){
        Level level = null;
        if (strLevel.equals("error")) {
            level = Level.ERROR;
        } else if (strLevel.equals("warning")) {
            level = Level.WARNING;
        } else if (strLevel.equals("info")) {
            level = Level.INFO;
        }else {
            throw new RuntimeException("level not recognized");
        }
        return level;
    }
}
