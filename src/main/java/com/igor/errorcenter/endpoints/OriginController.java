package com.igor.errorcenter.endpoints;

import com.igor.errorcenter.entity.Origin;
import com.igor.errorcenter.service.OriginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/origin")
public class OriginController {

    private OriginService originService;

    @PostMapping
    public ResponseEntity<Origin> created(@Valid @RequestBody OriginController originController){
        return null;
    }

    @PutMapping
    public ResponseEntity<Origin> update(@Valid @RequestBody OriginController originController){
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){

    }

    @GetMapping("/{id}")
    Origin findById(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/byLogin/{login}")
    List<Origin> findByLogin(@PathVariable("login") String login){
        return null;
    }

//    List<Origin> findEvents
}
