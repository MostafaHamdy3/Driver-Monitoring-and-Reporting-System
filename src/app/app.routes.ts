import { Routes } from '@angular/router';
import { MapComponent } from './map/map.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';

export const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "/signUp", component: SignUpComponent },
];
