import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Trip } from '../models/Trip';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class TripService {
  serialNumber: string = this.authService.getSerialNumber();
  pageNumber: number = 0;
  pageSize: number = 5;
  token: string = this.authService.getToken();
  private tripUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/trips`;
  private tripEventsUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/analysis/tripEvents`;

  constructor(private http: HttpClient, private authService: AuthService) {}

  getTrips(): Observable<Trip[]> {
    return this.http
      .get<TripGetResponse>(
        `${this.tripUrl}?pageNumber=${this.pageNumber}&pageSize=${this.pageSize}&serialNumber=${this.serialNumber}`,
        {
          headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` })
        }
      )
      .pipe(
        map((data) => {
          return data.content;
        })
      );
  }

  getTripEvents(tripId: number): Observable<object> {
    return this.http.get(`${this.tripEventsUrl}?tripId=${tripId}`,
      {
        headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` })
      }
    );
  }
}

interface TripGetResponse {
  content: Trip[];
}
