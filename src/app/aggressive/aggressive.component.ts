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
  chartGroup: ChartGroup = new ChartGroup();
  totalEvents: TotalEvents = new TotalEvents();

  AggCorneringBraking: number;

  TrafficSignViolations: number;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;
  public pieChartOptions: Partial<PieChartOptions>;

  constructor(
    private chartService: ChartsService,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    this.onGetTotalEvents();
    this.onGetChartGroupData();
  }

  renderFusionCharts() {
    FusionCharts.ready(() => {
      const chartObj = new FusionCharts({
        type: 'angulargauge',
        renderAt: 'chart-container',
        width: '450',
        height: '300',
        dataSource: {
          chart: {
            caption: 'Your Total Score',
            lowerLimit: '0',
            upperLimit: '100',
            "showValue": "1",
            "numberSuffix": "%",
            "theme": "fusion",
            "showToolTip": "0"
          },
          colorRange: {
            color: [{
              "minValue": "0",
              "maxValue": "50",
              "code": "#F2726F"
          }, {
              "minValue": "50",
              "maxValue": "75",
              "code": "#FFC533"
          }, {
              "minValue": "75",
              "maxValue": "100",
              "code": "#62B58F"
          }],
          },
          dials: {
            dial: [{ value: this.totalEvents.totalScore }],
          },
        },
      });

      chartObj.render();
    });
  }

  renderGroupChart() {
    this.chartOptions = {
      series: [
        {
          name: 'Aggressive Cornering & Braking',
          data: [
            this.chartGroup?.oneToSix?.aggCorneringAndBraking || 0,
            this.chartGroup?.sevenToTwelve?.aggCorneringAndBraking || 0,
            this.chartGroup?.nineteenToTwentyFour?.aggCorneringAndBraking || 0,
            this.chartGroup?.nineteenToTwentyFour?.aggCorneringAndBraking || 0,
          ],
        },
        {
          name: 'Swerve',
          data: [
            this.chartGroup?.oneToSix?.swerve || 0,
            this.chartGroup?.sevenToTwelve?.swerve || 0,
            this.chartGroup?.nineteenToTwentyFour?.swerve || 0,
            this.chartGroup?.nineteenToTwentyFour?.swerve || 0,
          ],
        },
        {
          name: 'Traffic Violation',
          data: [
            this.chartGroup?.oneToSix?.trafficViolation || 0,
            this.chartGroup?.sevenToTwelve?.trafficViolation || 0,
            this.chartGroup?.nineteenToTwentyFour?.trafficViolation || 0,
            this.chartGroup?.nineteenToTwentyFour?.trafficViolation || 0,
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

  renderPieChart() {
    this.AggCorneringBraking =
      this.totalEvents.aggTL +
        this.totalEvents.aggTR +
        this.totalEvents.suddenBraking || 0;

    this.TrafficSignViolations =
      this.totalEvents.speedLimitViolation +
        this.totalEvents.otherTrafficViolation || 0;

    this.pieChartOptions = {
      series: [
        this.totalEvents?.swerve,
        this.totalEvents?.normal,
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

  onGetTotalEvents() {
    this.dataService.getTotalEvents().subscribe((data: TotalEvents) => {
      this.totalEvents = data;

      this.renderFusionCharts();
      this.renderPieChart();
    });
  }

  onGetChartGroupData() {
    this.chartService.getChartGroupData().subscribe((data: ChartGroup) => {
      this.chartGroup = data;

      this.renderGroupChart();
    });
  }
}
