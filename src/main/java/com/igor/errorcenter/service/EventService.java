package com.igor.errorcenter.service;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.repository.EventRepository;
import com.igor.errorcenter.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;

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
    public List<Event> findByLevel(String level, Pageable pageable) {
        Level level1 = null;
        if (level.equals("error")) {
            level1 = Level.ERROR;
        } else if (level.equals("warning")) {
            level1 = Level.WARNING;
        } else if (level.equals("info")) {
            level1 = Level.INFO;
        }else {
            return new ArrayList<>();
        }
        return this.eventRepository.findByLevel(level1, pageable).getContent();
    }

    @Override
    public List<Event> findByLevelAndDate(String level, LocalDateTime date, Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByLevelAndDateAndOrigin(String level, LocalDateTime date, Long idOrigin, Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByEventDescription(String eventDescription, Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByOrigin(Long idOrigin, Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByOriginAndDate(Long idOrigin, LocalDateTime date) {
        return null;
    }

    @Override
    public List<Event> findByCreatedAt(LocalDateTime date, Pageable pageable) {
        return null;
    }

    @Override
    public List<Event> findByEventLog(String log, Pageable pageable) {
        return null;
    }
}
