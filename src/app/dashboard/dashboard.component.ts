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
import { TripService } from '../Services/user-trip.service';
import { Trip } from '../models/Trip';
import { DataService } from '../Services/user-data.service';
import { TotalEvents } from '../models/TotalEvents';
import { ChartGroup } from '../models/Charts';
import { ChartsService } from '../Services/charts.service';
import { AuthService } from '../Services/auth.service';

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
  totalEvents: TotalEvents = new TotalEvents();
  chartGroup: ChartGroup = new ChartGroup();

  selectedNavItem: string | null = 'dashboard';
  openDashboard = true;
  serialNumber: string = '';

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(
    private tripData: TripService,
    private dataService: DataService,
    private chartService: ChartsService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.onGetTrips();
    this.onGetTotalEvents();
    this.onGetChartGroupData();
  }

  onGetTrips() {
    this.tripData.getTrips().subscribe((data: Trip[]) => {
      this.tripDetails = data;
    });
  }

  onGetTotalEvents() {
    this.dataService.getTotalEvents().subscribe((data: TotalEvents) => {
      this.totalEvents = data;
    });
  }

  onGetChartGroupData() {
    this.chartService.getChartGroupData().subscribe((data: ChartGroup) => {
      this.chartGroup = data;

      this.renderGroupChart();
    });
  }

  onNavItemClicked(item: string) {
    item === 'dashboard'
      ? (this.openDashboard = true)
      : (this.openDashboard = false);
    this.selectedNavItem = item;
  }

  generateChartData(key: string) {
    return [
      this.chartGroup?.oneToSix?.[key] || 0,
      this.chartGroup?.sevenToTwelve?.[key] || 0,
      this.chartGroup?.thirteenToEighteen?.[key] || 0,
      this.chartGroup?.nineteenToTwentyFour?.[key] || 0,
    ];
  }

  renderGroupChart() {
    this.chartOptions = {
      series: [
        {
          name: 'Aggressive Cornering & Braking',
          data: this.generateChartData('aggCorneringAndBraking'),
        },
        {
          name: 'Swerve',
          data: this.generateChartData('swerve'),
        },
        {
          name: 'Traffic Violation',
          data: this.generateChartData('trafficViolation'),
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
          '01:00 - 06:00',
          '07:00 - 12:00',
          '13:00 - 18:00',
          '19:00 - 00:00',
        ],
      },
      yaxis: {
        title: {
          text: 'Violations Count',
        },
      },
      fill: {
        opacity: 1,
      },
      tooltip: {
        y: {
          formatter: function (val) {
            return val + ' thousands';
          },
        },
      },
    };
  }

  logoutHandler() {
    this.authService.logout();
  }
}
