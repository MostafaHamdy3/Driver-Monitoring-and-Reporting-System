import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  private baseUrl = "http://localhost:8088/user" ;
  constructor(private http : HttpClient) { }
  userLogin( user:User):Observable<object>{
    console.log(user) ; 
    return this.http.post(`${this.baseUrl}`, user) ; 
  }
}
