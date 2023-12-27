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

  totalSuddenBrake: number = 0;
  totalAggressiveLeft: number = 0;
  totalAggressiveRight: number = 0;
  totalAggressiveSwerve: number = 0;
  speedViolation: number = 0;
  totalOtherSign: number = 0;
  // respondedOtherSign: number = 0;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(
    private tripData: TripService,
    private dataService: DataService,
    private chartService: ChartsService
  ) {
    this.chartOptions = {
      series: [
        {
          name: 'Sudden Brake',
          data: [
            this.chartGroup.oneToSix.suddenBraking,
            this.chartGroup.sevenToTwelve.suddenBraking,
            this.chartGroup.nineteenToTwentyFour.suddenBraking,
            this.chartGroup.nineteenToTwentyFour.suddenBraking,
          ],
        },
        {
          name: 'Sudden Accedence',
          data: [
            this.chartGroup.oneToSix.suddenAcc,
            this.chartGroup.sevenToTwelve.suddenAcc,
            this.chartGroup.nineteenToTwentyFour.suddenAcc,
            this.chartGroup.nineteenToTwentyFour.suddenAcc,
          ],
        },
        {
          name: 'Aggressive Turn Left',
          data: [
            this.chartGroup.oneToSix.aggTL,
            this.chartGroup.sevenToTwelve.aggTL,
            this.chartGroup.nineteenToTwentyFour.aggTL,
            this.chartGroup.nineteenToTwentyFour.aggTL,
          ],
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
          '1:00 - 6:00',
          '7:00 - 12:00',
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

  ngOnInit() {
    this.onGetTrips();
    this.onGetTotalEvents();
    this.onGetChartGroupData();
  }

  onGetTrips() {
    this.tripData.getTrips().subscribe((data: Trip[]) => {
      console.log(data);
      this.tripDetails = data;
    });
  }

  onGetTotalEvents() {
    this.dataService.getTotalEvents().subscribe((data: TotalEvents) => {
      console.log(data);
      this.totalEvents = data;
      this.totalSuddenBrake = data.suddenBraking;
      this.totalAggressiveLeft = data.aggTL;
      this.totalAggressiveRight = data.aggTR;
      this.totalAggressiveSwerve = data.swerve;
      this.speedViolation = data.speedLimitViolation;
      this.totalOtherSign = data.otherTrafficViolation;
    });
  }

  onGetChartGroupData() {
    this.chartService.getChartGroupData().subscribe((data: ChartGroup) => {
      console.log(data);
      this.chartGroup = data;
      // this.chartGroup.oneToSix = data.oneToSix;
      // this.chartGroup.sevenToTwelve = data.sevenToTwelve;
      // this.chartGroup.thirteenToEighteen = data.thirteenToEighteen;
      // this.chartGroup.nineteenToTwentyFour = data.nineteenToTwentyFour;
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
