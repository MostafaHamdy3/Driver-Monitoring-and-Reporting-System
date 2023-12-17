import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';
import { FormsModule } from '@angular/forms';
import { UserRegister } from './user-register';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent implements OnInit {
  user:UserRegister =new UserRegister();
  constructor(private signupService: SignupService,private router: Router) { }
  
  ngOnInit() {}

  signUpHandler() {
    console.log(this.user);
    this.signupService.RegisterUser(this.user).subscribe(data=>{
      alert("Successfully User is register?")
     }
     ,error=>alert("Sorry User not register")
     );
  }
  logInHandler(){
    this.router.navigate(["/"]);
  }
}
