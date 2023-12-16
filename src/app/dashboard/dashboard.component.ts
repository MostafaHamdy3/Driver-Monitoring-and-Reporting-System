import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  selectedNavItem: string | null = "dashboard";
  openDashboard = true;

  constructor(private router: Router) { }

  ngOnInit() {}

  onNavItemClicked(item: string) {
    item === "dashboard" ? this.openDashboard = true : this.openDashboard = false;
    this.selectedNavItem = item;
  }

  getTripData(): Array<[string, string, number, string]> {
    return [
      ['10:00 AM', '2022-09-01', 50, 'Safe'],
      ['02:30 PM', '2022-09-02', 75, 'Aggressive'],
      ['04:45 PM', '2022-09-04', 60, 'Very Aggressive'],
    ];
  }
}
