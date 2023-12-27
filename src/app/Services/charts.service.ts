import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChartGroup } from '../models/Charts';

@Injectable({
  providedIn: 'root',
})
export class ChartsService {
  id: string = localStorage.getItem('driverId');
  chartCroupDetails: ChartGroup = new ChartGroup();

  private chartGroupUrl = `http://localhost:8082/api/v1/analysis/totalHourlyEvents`;

  constructor(private http: HttpClient) {}

  getChartGroupData(): Observable<object> {
    return this.http.get(`${this.chartGroupUrl}?id=${this.id}`);
  }

  updateEvents(chartData: ChartGroup) {
    this.chartCroupDetails = chartData;
  }
}
