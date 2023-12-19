import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';
import { FormsModule } from '@angular/forms';
import { UserRegister } from './user-register';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css',
})
export class SignUpComponent implements OnInit {
  user: UserRegister = new UserRegister();
  isLoading: boolean = false;
  constructor(private signupService: SignupService, private router: Router) {}

  ngOnInit() {}

  signUpHandler() {
    console.log(this.user);
    this.isLoading = true;
    this.signupService.RegisterUser(this.user).subscribe(
      () => {
        this.router.navigate(['/']);
      },
      (error) => {
        this.isLoading = false;
      }
    );
  }

  logInHandler() {
    this.router.navigate(['/']);
  }
}
