package com.igor.errorcenter.service.interfaces;

import com.igor.errorcenter.entity.Event;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventServiceInterface{

    List<Event> findAll(Pageable pageable);

    Event save(Event event);

    Optional<Event> findById(Long id);

    Optional<Event> update(Event event);

    void delete(Long id);

    Optional<List<Event>> findByLevel(String level, Pageable pageable);

    Optional<List<Event>> findByLevelAndDate(String level, LocalDateTime date, Pageable pageable);

    Optional<List<Event>> findByLevelAndDateAndOrigin(String level, LocalDateTime date, Long idOrigin, Pageable pageable);

    Optional<List<Event>> findByEventDescription(String eventDescription, Pageable pageable);

    Optional<List<Event>> findByOrigin(Long idOrigin, Pageable pageable);

    Optional<List<Event>> findByOriginAndDate(Long idOrigin, LocalDateTime date);

    Optional<List<Event>> findByCreatedAt(LocalDateTime date, Pageable pageable);

    Optional<List<Event>> findByEventLog(String log, Pageable pageable);

}
