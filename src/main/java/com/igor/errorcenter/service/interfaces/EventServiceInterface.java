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

    Event update(Event event);

    void delete(Long id);

    List<Event> findByLevel(String level, Pageable pageable);

    List<Event> findByLevelAndDate(String level, LocalDateTime date, Pageable pageable);

    List<Event> findByLevelAndDateAndOrigin(String level, LocalDateTime date, Long idOrigin, Pageable pageable);

    List<Event> findByEventDescription(String eventDescription, Pageable pageable);

    List<Event> findByOrigin(Long idOrigin, Pageable pageable);

    List<Event> findByOriginAndDate(Long idOrigin, LocalDateTime date);

    List<Event> findByCreatedAt(LocalDateTime date, Pageable pageable);

    List<Event> findByEventLog(String log, Pageable pageable);

}
