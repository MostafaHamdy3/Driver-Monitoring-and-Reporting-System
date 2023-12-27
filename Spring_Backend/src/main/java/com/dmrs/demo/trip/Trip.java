package com.dmrs.demo.trip;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Trip {

    @Id
    private String id;
    private String serialNumber;
    private String start_timestamp;// todo: change to ZonedDateTime
    private String end_timestamp;// todo: change to ZonedDateTime
    private int distance;
    private Status status;
}
