import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-dashboard-cards',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-cards.component.html',
  styleUrls: ['./dashboard-cards.component.css']
})
export class DashboardCardsComponent {

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
