package com.igor.errorcenter.repository;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.entity.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    Page<Event> findAll(Pageable pageable);

    @Override
    <S extends Event> S save(S s);

    @Override
    Optional<Event> findById(Long id);

    Page<Event> findByLevel(Level level, Pageable pageable);

    Page<Event> findByEventDescription(String eventDescription, Pageable pageable);

    Page<Event> findByOrigin(Origin origin, Pageable pageable);

    Page<Event> findByCreatedAt(LocalDateTime date, Pageable pageable);

    Page<Event> findByEventLog(String log, Pageable pageable);

}
