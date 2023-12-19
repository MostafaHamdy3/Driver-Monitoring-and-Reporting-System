import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { User } from '../Services/user';
import { FormsModule } from '@angular/forms';
import { UserLoginService } from '../Services/user-login.service';

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
      (data) => {
        console.log(data);
        
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        this.isLoginFailed = true;
        this.isLoading = false;
      }
    );
    // console.log(this.isLoginFailed);
  }

  showSignUpHandler() {
    this.router.navigate(['/signUp']);
  }
}
