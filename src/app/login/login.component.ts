import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';
import { User } from '../user';
import { FormsModule } from '@angular/forms';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule ,
    FormsModule , 
  
  ],
templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  user: User = new User(); 
  constructor(private router: Router , private userService : UserLoginService) { }

  ngOnInit() {}

  onLogin() {
    console.log(this.user) ; 
    this.userService.userLogin(this.user).subscribe(data=>{
      alert("login successfully") ;
      this.router.navigate(["/dashboard"]);
    } 
    , error=>alert(" Please enter correct email and password")) ;

  }

  showSignUpHandler() {
    this.router.navigate(["/signUp"]);
  }
}
