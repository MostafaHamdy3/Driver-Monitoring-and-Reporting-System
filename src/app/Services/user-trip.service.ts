import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Trip } from './Trip';

@Injectable({
  providedIn: 'root',
})
export class TripService {
  serialNumber: string = localStorage.getItem('serialNumber');
  pageNumber: number = 0;
  pageSize: number = 5;

  private tripUrl = `http://localhost:8082/api/v1/trips`;

  constructor(private http: HttpClient) {}

  getTrips(): Observable<Trip[]> {
    return this.http
      .get<TripGetResponse>(
        `${this.tripUrl}?pageNumber=${this.pageNumber}&pageSize=${this.pageSize}&serialNumber=${this.serialNumber}`
      )
      .pipe(
        map((data) => {
          return data.content.trip;
        })
      );
  }
}

interface TripGetResponse {
  content: {
    trip: Trip[];
  };
}
