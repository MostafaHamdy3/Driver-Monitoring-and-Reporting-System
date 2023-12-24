import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

import {
  ApexAxisChartSeries,
  ApexChart,
  ChartComponent,
  ApexDataLabels,
  ApexXAxis,
  ApexPlotOptions,
  ApexStroke,
  ApexYAxis,
  ApexLegend,
  ApexFill,
  ApexTooltip,
  NgApexchartsModule,
} from 'ng-apexcharts';
import { DriverVehicleService } from '../Services/user-data.service';
import { TripService } from '../Services/user-trip.service';
import { Trip, TripsContent } from '../Services/Trip';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  plotOptions: ApexPlotOptions;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  yaxis: ApexYAxis;
  fill: ApexFill;
  tooltip: ApexTooltip;
  legend: ApexLegend;
};

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    NgApexchartsModule,
  ],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  tripDetails: Trip[] = [];

  selectedNavItem: string | null = 'dashboard';
  openDashboard = true;
  serialNumber: string = '';

  totalSuddenBrake: number = 0;
  totalAggressiveLeft: number = 0;
  totalAggressiveRight: number = 0;
  totalAggressiveSwerve: number = 0;
  speedViolation: number = 0;
  totalOtherSign: number = 0;
  respondedOtherSign: number = 0;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(private tripData: TripService) {
    this.chartOptions = {
      series: [
        {
          name: 'Net Profit',
          data: [44, 55, 57, 56, 61, 58, 63, 60, 66],
        },
        {
          name: 'Revenue',
          data: [76, 85, 101, 98, 87, 105, 91, 114, 94],
        },
        {
          name: 'Free Cash Flow',
          data: [35, 41, 36, 26, 45, 48, 52, 53, 41],
        },
      ],
      chart: {
        type: 'bar',
        height: 350,
      },
      plotOptions: {
        bar: {
          horizontal: false,
          columnWidth: '55%',
          // endingShape: "rounded"
        },
      },
      dataLabels: {
        enabled: false,
      },
      stroke: {
        show: true,
        width: 2,
        colors: ['transparent'],
      },
      xaxis: {
        categories: [
          'Feb',
          'Mar',
          'Apr',
          'May',
          'Jun',
          'Jul',
          'Aug',
          'Sep',
          'Oct',
        ],
      },
      yaxis: {
        title: {
          text: '$ (thousands)',
        },
      },
      fill: {
        opacity: 1,
      },
      tooltip: {
        y: {
          formatter: function (val) {
            return '$ ' + val + ' thousands';
          },
        },
      },
    };
  }

  ngOnInit() {
    this.onGetTrips();
  }

  onGetTrips() {
    this.tripData.getTrips().subscribe((trip: TripsContent) => {
      console.log(trip);
      this.tripDetails = this.tripDetails.concat(trip.content);
    });
  }

  onNavItemClicked(item: string) {
    item === 'dashboard'
      ? (this.openDashboard = true)
      : (this.openDashboard = false);
    this.selectedNavItem = item;
  }

  logoutHandler() {
    localStorage.removeItem('token');
    localStorage.removeItem('driverId');
    localStorage.removeItem('serialNumber');
  }

  // getTripData(): Array<[string, string, number, string]> {
  //   return [
  //     ['10:00 AM', '2022-09-01', 50, 'Safe'],
  //     ['02:30 PM', '2022-09-02', 75, 'Aggressive'],
  //     ['04:45 PM', '2022-09-04', 60, 'Very Aggressive'],
  //   ];
  // }
}
