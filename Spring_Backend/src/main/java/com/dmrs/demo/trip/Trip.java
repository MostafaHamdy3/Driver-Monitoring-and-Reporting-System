package com.dmrs.demo.trip;

import com.dmrs.demo.RTVehicleData.Status;
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
    private String start_timestamp;
    private String end_timestamp;
    private int distance;
    private Status status;
}
