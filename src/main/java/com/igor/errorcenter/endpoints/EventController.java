package com.igor.errorcenter.endpoints;

import com.igor.errorcenter.dto.EventDTO;
import com.igor.errorcenter.dto.EventLogDTO;
import com.igor.errorcenter.entity.Event;
import com.igor.errorcenter.service.EventService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event){
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Event> update(@Valid @RequestBody Event event){
        return new ResponseEntity<Event>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventLogDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity<EventLogDTO>(convertToEventLogDto(this.eventService.findById(id).get()),
                HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<EventDTO> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findAll(pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byOrigin/{idOrigin}")
    public List<EventDTO> findByOrigin(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @PathVariable("idOrigin") Long idOrigin){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByOrigin(idOrigin, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byOriginAndDate/{idOrigin}/{date}")
    public List<EventDTO> findByOriginAndDate(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @PathVariable("idOrigin") Long idOrigin,
                                           @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByOriginAndDate(idOrigin, date, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byLevel/{level}")
    public List<EventDTO> findByLevel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevel(level, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byLevelAndDate/{level}/{date}")
    public List<EventDTO> findByLevelAndDate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevelAndDate(level, date, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byLevelAndDateAndOrigin/{level}/{date}/{idOrigin}")
    public List<EventDTO> findByLevelAndDateAndOrigin(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("level") String level,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @PathVariable("idOrigin") Long idOrigin){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByLevelAndDateAndOrigin(level, date, idOrigin, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byDescription/{description}")
    public List<EventDTO> findByDescription(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @PathVariable("description") String description){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByEventDescription(description, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byLog/{log}")
    public List<EventDTO> findByLog(@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(defaultValue = "id") String sortBy,
                          @PathVariable("log") String log){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByEventLog(log, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byDate/{date}")
    List<EventDTO> findByDate(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "id") String sortBy,
                           @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
        return this.eventService.findByCreatedAt(date, pageable).stream()
                .map(this::convertToEventDto)
                .collect(Collectors.toList());
    }

    private EventLogDTO convertToEventLogDto(Event event){
        EventLogDTO eventLogDTO = modelMapper.map(event, EventLogDTO.class);
        return eventLogDTO;
    }

    private EventDTO convertToEventDto(Event event){
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        return eventDTO;
    }

}
