import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChartGroup } from '../models/Charts';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root',
})
export class ChartsService {
  id: string = this.authService.getDriverId();
  chartCroupDetails: ChartGroup;
  token:string = this.authService.getToken();
  private chartGroupUrl = `https://dmrs-c487bb5f6150.herokuapp.com/api/v1/analysis/totalHourlyEvents`;

  constructor(private http: HttpClient,private authService: AuthService) {}

  getChartGroupData(): Observable<object> {

    return this.http.get(`${this.chartGroupUrl}?driverId=${this.id}`,
      {
        headers: new HttpHeaders({ "Authorization": `Bearer ${this.token}` }),
      }
    );
  }

  updateEvents(chartData: ChartGroup) {
    return chartData;
  }
}
