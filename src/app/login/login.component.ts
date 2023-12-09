import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule],
templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit() {}

  onLogin() {
    this.router.navigate(["/dashboard"]);
  }

  showSignUpHandler() {
    this.router.navigate(["/signUp"]);
  }
}
