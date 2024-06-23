import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { User } from '../models/userLogin';
import { FormsModule } from '@angular/forms';
import { UserLoginService } from '../Services/user-login.service';
import { Driver } from '../models/Driver';
import { AuthService } from '../Services/auth.service';

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
  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit() {}

  onLogin() {
    this.isLoading = true;
    this.authService.login(this.user).subscribe(
      (response: LoginResponse) => {
        this.isLoading = false;
        this.isLoginFailed = false;
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        this.isLoading = false;
        this.isLoginFailed = true;
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

interface LoginResponse {
  code: string;
  successMessage: string;
  data: {
    driverId: string;
    serialNumber:string;
    token: string;
  };
  // add other properties if needed
}