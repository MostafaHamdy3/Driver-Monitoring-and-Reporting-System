import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegister } from '../sign-up/user-register';
@Injectable({
  providedIn: 'root',
})
export class SignupService {
  baseUrl = 'http://localhost:8082/api/v1/registration';
  constructor(private httpClient: HttpClient) {}

  RegisterUser(userData: UserRegister) {
    return this.httpClient.post(`${this.baseUrl}`, userData);
  }
}
