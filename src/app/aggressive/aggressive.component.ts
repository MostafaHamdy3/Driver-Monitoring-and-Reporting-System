import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import FusionCharts from 'fusioncharts';
import AngularGauge from 'fusioncharts/fusioncharts.widgets';
import Charts from 'fusioncharts/fusioncharts.charts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';

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
  ApexNonAxisChartSeries,
  ApexResponsive,
  NgApexchartsModule,
} from 'ng-apexcharts';
import { ChartsService } from '../Services/charts.service';
import { ChartGroup } from '../models/Charts';
import { DataService } from '../Services/user-data.service';
import { TotalEvents } from '../models/TotalEvents';

// Apply the chart and theme modules
Charts(FusionCharts);
AngularGauge(FusionCharts);
FusionTheme(FusionCharts);

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

export type PieChartOptions = {
  series: ApexNonAxisChartSeries;
  chart: ApexChart;
  // chart: ApexChart & {
  //   type: 'pie';
  //   colors?: string[];
  // };
  responsive: ApexResponsive[];
  labels: any;
};

@Component({
  selector: 'app-aggressive',
  standalone: true,
  imports: [CommonModule, NgApexchartsModule],
  templateUrl: './aggressive.component.html',
  styleUrl: './aggressive.component.css',
})
export class AggressiveComponent implements OnInit {
  totalScore: string = localStorage.getItem('totalScore');
  chartGroup: ChartGroup = new ChartGroup();
  totalEvents: TotalEvents = new TotalEvents();

  AggCorneringBraking =
    this.totalEvents.aggTL +
      this.totalEvents.aggTR +
      this.totalEvents.suddenBraking || 0;

  TrafficSignViolations =
    this.totalEvents.speedLimitViolation +
      this.totalEvents.otherTrafficViolation || 0;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;
  public pieChartOptions: Partial<PieChartOptions>;

  constructor(
    private chartService: ChartsService,
    private dataService: DataService
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

    this.pieChartOptions = {
      series: [
        this.totalEvents.swerve,
        this.totalEvents.normal,
        this.AggCorneringBraking,
        this.TrafficSignViolations,
      ],
      chart: {
        width: 420,
        type: 'pie',
      },
      labels: [
        'Swerve',
        'Normal',
        'Aggressive Cornering & Braking',
        'Traffic Sign Violations',
      ],
      responsive: [
        {
          breakpoint: 480,
          options: {
            chart: {
              width: 240,
            },
            legend: {
              position: 'bottom',
            },
          },
        },
      ],
    };
  }

  ngOnInit(): void {
    this.onGetTotalEvents();
    this.onGetChartGroupData();
    FusionCharts.ready(() => {
      const chartObj = new FusionCharts({
        type: 'angulargauge',
        renderAt: 'chart-container',
        width: '450',
        height: '300',
        // dataFormat: 'json',
        dataSource: {
          chart: {
            caption: '',
            subcaption: '',
            lowerLimit: '0',
            upperLimit: '180',
            theme: 'fusion',
          },
          colorRange: {
            color: [
              { minValue: '0', maxValue: '70', code: '#6baa01' },
              { minValue: '70', maxValue: '100', code: '#f8bd19' },
              { minValue: '100', maxValue: '180', code: '#e44a00' },
            ],
          },
          dials: {
            dial: [{ value: this.totalScore }],
          },
        },
      });

      chartObj.render();
    });
  }

  onGetTotalEvents() {
    this.dataService.getTotalEvents().subscribe((data: TotalEvents) => {
      console.log(data);
      this.totalEvents = data;
      // this.totalSuddenBrake = data.suddenBraking;
      // this.totalAggressiveLeft = data.aggTL;
      // this.totalAggressiveRight = data.aggTR;
      // this.totalAggressiveSwerve = data.swerve;
      // this.speedViolation = data.speedLimitViolation;
      // this.totalOtherSign = data.otherTrafficViolation;
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
}
