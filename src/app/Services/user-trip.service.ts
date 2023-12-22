import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { Trip } from "./Trip";

@Injectable({
  providedIn: 'root'
})

export class TripService {
  tripDetails: Trip = new Trip();
  pageNumber: number = 0;
  pageSize: number = 5;

  private tripUrl = `http://localhost:8082/api/v1/trips`;

  constructor(private http: HttpClient) { }

  getTrips(): Observable<object> {
    return this.http.get(`${this.tripUrl}?pageNumber=${this.pageNumber}&pageSize=${this.pageSize}&serialNumber=${this.tripDetails.serialNumber}`);
  }
}
