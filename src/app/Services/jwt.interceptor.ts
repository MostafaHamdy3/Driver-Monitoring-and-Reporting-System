// src/app/interceptors/jwt.interceptor.ts
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.authService.getToken();

    console.log("we are in the jwt interceptor and the token is: ", token);
    if (token) {
      const modRequest = request.clone({
        headers: request.headers.append('Authorization', `Bearer ${token}`)
      });
    }

    return next.handle(request);
  }
}
