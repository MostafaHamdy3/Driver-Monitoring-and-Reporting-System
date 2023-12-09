// import { Component, OnInit } from '@angular/core';
// import { CommonModule } from '@angular/common';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-dashboard',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './dashboard.component.html',
//   styleUrl: './dashboard.component.css'
// })
// export class DashboardComponent implements OnInit {
//   selectedNavItem: string | null = null;
//   constructor(private router: Router) { }

//   ngOnInit() {}

//   onNavItemClicked(item: string) {
//     this.selectedNavItem = item;
//     // Handle navigation or other logic if needed
//   }
//   onLogout() {
//     this.router.navigate(["/signUp"]);
//   }
// }

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  selectedNavItem: string | null = null;

  constructor(private router: Router) { }

  ngOnInit() {}

  onNavItemClicked(item: string) {
    this.selectedNavItem = item;
    // Handle navigation or other logic if needed
  }

  onLogout() {
    this.router.navigate(['/signUp']);
  }
}
