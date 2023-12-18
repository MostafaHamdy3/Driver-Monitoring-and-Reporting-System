import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-trips-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './trips-table.component.html',
  styleUrls: ['./trips-table.component.css']
})

export class TripsTableComponent {
  suddenBrake: number = 0;
  aggressiveLeft: number = 0;
  aggressiveRight: number = 0;
  aggressiveSwerve: number = 0;
  speedViolation: number = 0;
  totalOtherSign: number = 0;
  respondedOtherSign: number = 0;

  constructor() { }

  getTripData(): Array<[string, string, number, string]> {
    return [
      ['10:00 AM', '2022-09-01', 50, 'Safe'],
      ['02:30 PM', '2022-09-02', 75, 'Aggressive'],
      ['09:15 AM', '2022-09-03', 30, 'Safe'],
      ['04:45 PM', '2022-09-04', 60, 'Very Aggressive'],
      ['08:30 AM', '2022-09-05', 45, 'Safe']
    ];
  }
}
