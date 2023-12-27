package com.dmrs.demo.RTVehicleData;

import com.dmrs.demo.RTVehicleData.conditions.Conditions;
import com.dmrs.demo.RTVehicleData.conditions.DriverBehaviour;
import com.dmrs.demo.RTVehicleData.conditions.RoadSign;
import com.dmrs.demo.RTVehicleData.conditions.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class RTVehicleData {
    @Id
    private String id;
    private String serialNumber;
    private float latitude;
    private float longitude;
    private String timestamp; // todo: change to ZonedDateTime
    private Status status;
    private Conditions conditions;

    public RTVehicleData(String serialNumber, float latitude, float longitude, String timestamp, Status status, Conditions conditions) {
        this.serialNumber = serialNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.status = status;
        this.conditions = conditions;
    }
}
