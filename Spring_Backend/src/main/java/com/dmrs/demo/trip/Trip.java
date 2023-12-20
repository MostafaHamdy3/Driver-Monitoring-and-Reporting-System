package com.dmrs.demo.trip;

import com.dmrs.demo.RTVehicleData.Status;
import com.mongodb.BSONTimestampCodec;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Data
@Document
public class Trip {

    @Id
    private String id;
    private String serialNumber;
    private ZonedDateTime start_timestamp;
    private ZonedDateTime end_timestamp;
    private int distance;
    private Status status;
}
