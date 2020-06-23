package com.igor.errorcenter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.errorcenter.entity.Level;
import com.igor.errorcenter.entity.Origin;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;

    private Level level;

    private String eventDescription;

    private Origin origin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

}
