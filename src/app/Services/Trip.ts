export class Trip {
  id: string;
  serialNumber: string;
  start_timestamp: string;
  end_timestamp: string;
  distance: number;
  status: Status;
}

export class TripsContent {
  content: Trip[];
}

export enum Status{
  Normal, Aggressive, Very_Aggressive
}
