import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegister } from './sign-up/user-register';
@Injectable({
  providedIn: 'root'
})
export class SignupService {
  baseUrl="http://localhost:8081/user";
  constructor(private httpClient:HttpClient) { }

  RegisterUser(user:UserRegister){
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
}
