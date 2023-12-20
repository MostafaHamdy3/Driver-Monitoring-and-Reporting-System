import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { Driver } from "./Driver";
import { Vehicle } from "./Vehicle";

@Injectable({
  providedIn: 'root'
})

export class DriverVehicleService {
  token: string = localStorage.getItem('token');

  private driverUrl = `http://localhost:8082/api/v1/driver?token=${this.token}`;
  private vehicleUrl = `http://localhost:8082/api/v1/vehicle?token=${this.token}`;

  constructor(private http: HttpClient) { }

  getDriver(): Observable<object> {
    // console.log("Token 2 = "+this.token)
    return this.http.get(`${this.driverUrl}`);
  }

  getVehicle(): Observable<object> {
    return this.http.get(`${this.vehicleUrl}`);
  }

  updateDriver(driverData: Driver): Observable<object> {
    return this.http.put(`${this.driverUrl}`, driverData);
  }

  updateVehicle(vehicleData: Vehicle): Observable<object> {
    return this.http.put(`${this.vehicleUrl}`, vehicleData);
  }
}
