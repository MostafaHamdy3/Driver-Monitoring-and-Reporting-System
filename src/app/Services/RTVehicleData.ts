export class RTVehicleData {
    id!: string;
    serialNumber!: string;
    gps!: string;
    speed!: number;
    timestamp!: string;
    driverBehavior!: DriverBehavior;
    speedLimit!: number;
    roadSign!: RoadSign;
    roadSignAdherence!: boolean;

    constructor(id: string, serialNumber: string, gps: string, speed: number, timestamp: string, driverBehavior: DriverBehavior, speedLimit: number, roadSign: RoadSign, roadSignAdherence: boolean) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.gps = gps;
        this.speed = speed;
        this.timestamp = timestamp;
        this.driverBehavior = driverBehavior;
        this.speedLimit = speedLimit;
        this.roadSign = roadSign;
        this.roadSignAdherence = roadSignAdherence;
    }
}

enum DriverBehavior {

    NORMAL,SUDDEN_ACCEL,SUDDEN_RT,SUDDEN_LT,SUDDEN_BR,
    IN_LANE,OUT_LANE,
    FORWARD_COLLISION_WARNING

}

enum RoadSign {

    NULL,LEFT_TURN,RIGHT_TURN,STOP,TRAFFIC_LIGHT,PEDESTRIAN_CROSSING
}