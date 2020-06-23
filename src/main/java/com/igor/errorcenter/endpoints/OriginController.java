package com.igor.errorcenter.endpoints;

import com.igor.errorcenter.entity.Origin;
import com.igor.errorcenter.service.OriginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/origin")
public class OriginController {

    private OriginService originService;

    @PostMapping
    public ResponseEntity<Origin> created(@Valid @RequestBody Origin origin){
        return new ResponseEntity<Origin>(this.originService.save(origin), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Origin> update(@Valid @RequestBody Origin origin){
        return new ResponseEntity<Origin>(this.originService.update(origin), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.originService.delete(id);
    }

    @GetMapping("/{id}")
    ResponseEntity<Origin> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Origin>(this.originService.findById(id).orElseThrow(
                () -> new RuntimeException("Origin not found")), HttpStatus.OK);
    }

    @GetMapping("/byLogin/{login}")
    ResponseEntity<Origin> findByLogin(@PathVariable("login") String login){
        return new ResponseEntity<Origin>(this.originService.findByLogin(login).get(), HttpStatus.OK);
    }

//    List<Origin> findEvents
}
