package com.dmrs.demo.vehicleData;

import com.mongodb.BSONTimestampCodec;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@Data
@Document
public class VehicleData {
    @Id
    private String id;
    private String serialNumber;
    private String gps;
    private int speed;
    private BSONTimestampCodec timestamp;
    private Status status;
    private DriverBehaviour driverBehaviour;
    private int speedLimit ;
    private RoadSign roadSign;
    private boolean roadSignAdherence ;

    public VehicleData(String serialNumber, String gps, int speed, BSONTimestampCodec timestamp, Status status, DriverBehaviour driverBehaviour) {
        this.serialNumber = serialNumber;
        this.gps = gps;
        this.speed = speed;
        this.timestamp = timestamp;
        this.status = status;
        this.driverBehaviour = driverBehaviour;
    }

    public VehicleData(String id, String serialNumber, String gps, int speed, BSONTimestampCodec timestamp, Status status, DriverBehaviour driverBehaviour, int speedLimit, RoadSign roadSign, boolean roadSignAdherence) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.gps = gps;
        this.speed = speed;
        this.timestamp = timestamp;
        this.status = status;
        this.driverBehaviour = driverBehaviour;
        this.speedLimit = speedLimit;
        this.roadSign = roadSign;
        this.roadSignAdherence = roadSignAdherence;
    }

    public VehicleData(String serialNumber, String gps, int speed, BSONTimestampCodec timestamp, Status status, DriverBehaviour driverBehaviour, int speedLimit) {
        this.serialNumber = serialNumber;
        this.gps = gps;
        this.speed = speed;
        this.timestamp = timestamp;
        this.status = status;
        this.driverBehaviour = driverBehaviour;
        this.speedLimit = speedLimit;
    }

    public VehicleData(String serialNumber, String gps, int speed, BSONTimestampCodec timestamp, Status status) {
        this.serialNumber = serialNumber;
        this.gps = gps;
        this.speed = speed;
        this.timestamp = timestamp;
        this.status = status;
    }
}
