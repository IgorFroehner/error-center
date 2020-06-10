package com.igor.errorcenter.repository;

import com.igor.errorcenter.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    Event save(Event e);

    @Override
    List<Event> findAll();

    //Optional<List<Event>> findByLevel();

    //Optional<List<Event>> findByOrigem();
}
