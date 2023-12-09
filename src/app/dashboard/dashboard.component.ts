import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})

export class DashboardComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit() {}

  onLogout() {
    this.router.navigate(["/signUp"]);
  }

  profileHandler() {
    this.router.navigate(["/dashboard/profileSetting"]);
  }
}
