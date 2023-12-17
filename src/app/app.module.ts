import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AgmCoreModule } from '@agm/core';
import { MatIconModule } from '@angular/material/icon';
import { routes } from './app.routes';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';
import { TripsTableComponent } from './trips-table/trips-table.component';
import { RouterModule } from '@angular/router'; 

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    DashboardComponent,
    TripsTableComponent,
    ProfileSettingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MatIconModule,
    RouterModule, 
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: ""
    })
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
