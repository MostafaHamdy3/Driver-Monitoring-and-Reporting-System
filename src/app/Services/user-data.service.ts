import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../models/Driver';
import { Vehicle } from '../models/Vehicle';
import { TotalEvents } from '../models/TotalEvents';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  driverDetails: Driver = new Driver();
  vehicleDetails: Vehicle = new Vehicle();
  totalEventsDetails: TotalEvents = new TotalEvents();
  token: string = localStorage.getItem('token');
  id: string = localStorage.getItem('driverId');

  private driverUrl = `http://localhost:8082/api/v1/driver`;
  private vehicleUrl = `http://localhost:8082/api/v1/vehicle`;
  private totalEventsUrl = `http://localhost:8082/api/v1/analysis/totalEvents`;

  constructor(private http: HttpClient) {}

  getDriver(): Observable<object> {
    return this.http.get(`${this.driverUrl}?token=${this.token}`);
  }

  getVehicle(): Observable<object> {
    return this.http.get(`${this.vehicleUrl}?id=${this.id}`);
  }

  updateDriverDetails(driver: Driver) {
    this.driverDetails = driver;
  }

  updateVehicleDetails(vehicle: Vehicle) {
    this.vehicleDetails = vehicle;
  }

  updateDriver(driverData: Driver): Observable<object> {
    return this.http.put(`${this.driverUrl}`, driverData);
  }

  updateVehicle(vehicleData: Vehicle): Observable<object> {
    return this.http.put(`${this.vehicleUrl}`, vehicleData);
  }

  getTotalEvents(): Observable<object> {
    return this.http.get(`${this.totalEventsUrl}?driverId=${this.id}`);
  }

  updateEvents(totalEvents: TotalEvents) {
    this.totalEventsDetails = totalEvents;
  }
}
