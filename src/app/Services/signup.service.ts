import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegister } from '../sign-up/user-register';
@Injectable({
  providedIn: 'root',
})
export class SignupService {
  baseUrl = 'https://dmrs-c487bb5f6150.herokuapp.com/auth/register';
  constructor(private httpClient: HttpClient) {}

  RegisterUser(userData: UserRegister) {
    return this.httpClient.post(`${this.baseUrl}`, userData);
  }
}
