package com.igor.errorcenter.repository;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    Event save(Event e);

    @Override
    List<Event> findAll();

    @Override
    Optional<Event> findById(Long id);

    Optional<List<Event>> findByLevel(Level level);

    Optional<List<Event>> findByEventDescription(String eventDescription);

    Optional<List<Event>> findByOrigin(Origin origin);

    Optional<List<Event>> findByCreatedAt(LocalDateTime date);

    Optional<List<Event>> findByEventLog(String log);

}
