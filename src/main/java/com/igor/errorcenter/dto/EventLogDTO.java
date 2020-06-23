package com.igor.errorcenter.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventLogDTO {

    Long id;
    String log;

}
