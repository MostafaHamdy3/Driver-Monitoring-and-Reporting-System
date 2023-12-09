import { Routes } from '@angular/router';
import { MapComponent } from './map/map.component';
import { DashboardCardsComponent } from './dashboard-cards/dashboard-cards.component';
export const routes: Routes = [
  { path: "", component:  DashboardCardsComponent},
  { path: "", component: MapComponent },
];
