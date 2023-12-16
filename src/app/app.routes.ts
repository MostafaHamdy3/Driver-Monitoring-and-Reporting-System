import { Routes } from '@angular/router';
import { MapComponent } from './map/map.component';
import { TripsTableComponent } from './trips-table/trips-table.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';

export const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "signUp", component: SignUpComponent },
  { path: "dashboard", component: DashboardComponent, children: [
    { path: "eventLog", component: TripsTableComponent },
    { path: "profileSetting", component: ProfileSettingComponent },
    { path: "map", component: MapComponent },
  ] },
];
