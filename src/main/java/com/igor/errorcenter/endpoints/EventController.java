package com.igor.errorcenter.endpoints;

import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event){
        return null;
    }

    @PutMapping
    public ResponseEntity<Event> update(@Valid @RequestBody Event event){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping
    public List<Event> findAll(Pageable pageable){
        return null;
    }

    @GetMapping("/byOrigin/{idOrigin}")
    public List<Event> findByOrigin(@PathVariable("idOrigin") Long idOrigin, Pageable pageable){
        return null;
    }

    @GetMapping("/byOriginAndDate/{idOrigin}/{date}")
    public List<Event> findByOrigin(@PathVariable("idOrigin") Long idOrigin,
                                    @PathVariable("date") LocalDateTime date,
                                    Pageable pageable){
        return null;
    }

    @GetMapping("/byLevel/{level}")
    public List<Event> findByLevel(@PathVariable String level, Pageable pageable){
        return null;
    }

    @GetMapping("/byLevelAndDate/{level}/{date}")
    public List<Event> findByLevelAndDate(@PathVariable String level,
                                          @PathVariable LocalDateTime date,
                                          Pageable pageable){
        return null;
    }

    @GetMapping("/byLevelAndDateAndOrigin/{level}/{date}/{idOrigin}")
    List<Event> findByLevelAndDateAndOrigin(@PathVariable String level,
                                            @PathVariable LocalDateTime date,
                                            @PathVariable Long idOrigin,
                                            Pageable pageable){
        return null;
    }

    @GetMapping("/byDescription/{description}")
    List<Event> findByDescription(@PathVariable String description, Pageable pageable){
        return null;
    }

    @GetMapping("/byLog/{log}")
    List<Event> findByLog(@PathVariable String log, Pageable pageable){
        return null;
    }

    @GetMapping("/byDate/{date}")
    List<Event> findByDate(@PathVariable LocalDateTime date, Pageable pageable){
        return null;
    }

}
