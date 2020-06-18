package com.igor.errorcenter.dto;

import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.entity.Origin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private Level level;
    private String eventDescription;
    private Origin origin;
    private LocalDateTime createdAt;

}
