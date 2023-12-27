import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { User } from '../models/userLogin';
import { FormsModule } from '@angular/forms';
import { UserLoginService } from '../Services/user-login.service';
import { Driver } from '../models/Driver';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  user: User = new User();
  isLoading: boolean = false;
  isLoginFailed: boolean = false;
  constructor(private router: Router, private userService: UserLoginService) {}

  ngOnInit() {}

  onLogin() {
    this.isLoading = true;
    this.userService.userLogin(this.user).subscribe(
      (data: LoginResponse) => {
        localStorage.setItem('token', data.token);
        localStorage.setItem('driverId', data.driverId);
        localStorage.setItem('serialNumber', data.vehicleSerialNumber);
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        this.isLoginFailed = true;
        this.isLoading = false;
      }
    );
  }

  showSignUpHandler() {
    this.router.navigate(['/signUp']);
  }
}

interface LoginResponse {
  token: string;
  driverId: string;
  vehicleSerialNumber: string;
  // add other properties if needed
}
