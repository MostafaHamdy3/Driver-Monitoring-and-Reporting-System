export class Trip{

    id!: string;
    serialNumber!: string;
    start_timestamp!: string;
    end_timestamp!: string;
    distance!: number;
    status!: Status;

    constructor(id: string, serialNumber: string, start_timestamp: string, end_timestamp: string, distance: number, status: Status) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.start_timestamp = start_timestamp;
        this.end_timestamp = end_timestamp;
        this.distance = distance;
        this.status = status;
    }
}

export enum Status{
    Normal, Aggressive, Very_Aggressive
}