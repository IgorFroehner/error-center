package com.igor.errorcenter.mapper;

import com.igor.errorcenter.dto.EventLogDTO;
import com.igor.errorcenter.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mappings({
            @Mapping(source = "id", target = "eventId"),
            @Mapping(source = "log", target = "eventLog")
    })
    EventLogDTO map(Event event);

}
