import {
  HttpClient,
  HttpClientModule,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/userLogin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserLoginService {
  private baseUrl = 'http://localhost:8082/api/v1/login';
  constructor(private http: HttpClient) {}
  userLogin(authData: User): Observable<object> {
    return this.http.post(`${this.baseUrl}`, authData);
  }
}
