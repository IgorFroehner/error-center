package com.igor.errorcenter.endpoints;

import com.igor.errorcenter.dto.EventLogDTO;
import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.mapper.EventMapper;
import com.igor.errorcenter.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

//    private EventMapper mapper;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event){
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Event> update(@Valid @RequestBody Event event){
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EventLogDTO> findById(@PathVariable("id") Long id){
//        return new ResponseEntity<EventLogDTO>(this.eventService.findById(id).map(mapper::map).orElse(null),
//                HttpStatus.ACCEPTED);
//    }

    @GetMapping
    public List<Event> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findAll(pageable);
    }

    @GetMapping("/byOrigin/{idOrigin}")
    public List<Event> findByOrigin(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @PathVariable("idOrigin") Long idOrigin){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByOrigin(idOrigin, pageable);
    }

    @GetMapping("/byOriginAndDate/{idOrigin}/{date}")
    public List<Event> findByOriginAndDate(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @PathVariable("idOrigin") Long idOrigin,
                                           @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByOriginAndDate(idOrigin, date, pageable);
    }

    @GetMapping("/byLevel/{level}")
    public List<Event> findByLevel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevel(level, pageable);
    }

    @GetMapping("/byLevelAndDate/{level}/{date}")
    public List<Event> findByLevelAndDate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevelAndDate(level, date, pageable);
    }

    @GetMapping("/byLevelAndDateAndOrigin/{level}/{date}/{idOrigin}")
    List<Event> findByLevelAndDateAndOrigin(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @PathVariable("idOrigin") Long idOrigin){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevelAndDateAndOrigin(level, date, idOrigin, pageable);
    }

    @GetMapping("/byDescription/{description}")
    List<Event> findByDescription(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @PathVariable("description") String description){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByEventDescription(description, pageable);
    }

    @GetMapping("/byLog/{log}")
    List<Event> findByLog(@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(defaultValue = "id") String sortBy,
                          @PathVariable("log") String log){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByEventLog(log, pageable);
    }

    @GetMapping("/byDate/{date}")
    List<Event> findByDate(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "id") String sortBy,
                           @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByCreatedAt(date, pageable);
    }

}
