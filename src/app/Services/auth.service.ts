import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../models/userLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://dmrs-c487bb5f6150.herokuapp.com/auth';

  constructor(private http: HttpClient) { }

  login(authData: User): Observable<any> {
    console.log(authData);
  return  this.http.post<any>(`${this.apiUrl}/login`, authData).pipe(
  tap((response: LoginResponse) => {
    console.log(response);
    localStorage.setItem('token', response.data.token);
    localStorage.setItem('serialNumber', response.data.serialNumber);
    localStorage.setItem('driverId', response.data.driverId);
  }));
  }


  getToken(): string | null {
    return localStorage.getItem('token');
  }

  getDriverId(): string | null {
    return localStorage.getItem('driverId');
  }

  getSerialNumber(): string | null {
    return localStorage.getItem('serialNumber');
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('driverId');
    localStorage.removeItem('serialNumber');
    
  }
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