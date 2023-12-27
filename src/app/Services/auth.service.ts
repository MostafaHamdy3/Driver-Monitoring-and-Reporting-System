import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('driverId');
    localStorage.removeItem('serialNumber');
  }
}
