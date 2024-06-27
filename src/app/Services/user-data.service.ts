import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../models/Driver';
import { Vehicle } from '../models/Vehicle';
import { TotalEvents } from '../models/TotalEvents';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  driverDetails: Driver = new Driver();
  vehicleDetails: Vehicle = new Vehicle();
  totalEventsDetails: TotalEvents = new TotalEvents();
  id: string = this.authService.getDriverId();
  token: string = this.authService.getToken();

  private driverUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/driver`;
  private vehicleUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/vehicle`;
  private totalEventsUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/analysis/totalEvents`;

  constructor(private http: HttpClient,private authService: AuthService) {}

  getDriver(): Observable<object> {
    return this.http.get(`${this.driverUrl}?id=${this.id}`,{
      headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` }),
    });
  }

  getVehicle(): Observable<object> {
    return this.http.get(`${this.vehicleUrl}?id=${this.id}`,{
      headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` }),
    });
  }

  updateDriverDetails(driver: Driver) {
    this.driverDetails = driver;
  }

  updateVehicleDetails(vehicle: Vehicle) {
    this.vehicleDetails = vehicle;
  }

  updateDriver(driverData: Driver): Observable<object> {
    return this.http.put(`${this.driverUrl}`, driverData,{
      headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` }),
    });
  }

  updateVehicle(vehicleData: Vehicle): Observable<object> {
    return this.http.put(`${this.vehicleUrl}`, vehicleData,{
      headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` }),
    });
  }

  getTotalEvents(): Observable<object> {
    return this.http.get(`${this.totalEventsUrl}?driverId=${this.id}`,
      {
        headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` })
      }
    );
  }

  updateEvents(totalEvents: TotalEvents) {
    this.totalEventsDetails = totalEvents;
  }
}
