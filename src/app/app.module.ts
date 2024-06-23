import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AgmCoreModule } from '@agm/core';
import { MatIconModule } from '@angular/material/icon';
import { NgxChartsModule }from '@swimlane/ngx-charts';  // added
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';
import { UserLoginService } from './Services/user-login.service' ;
import { SignupService } from './Services/signup.service';
import { TripsTableComponent } from './trips-table/trips-table.component';
import { RouterModule } from '@angular/router';
import { JwtInterceptor } from './Services/jwt.interceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

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
    HttpClientModule,
    MatIconModule,
    RouterModule,
    BrowserAnimationsModule,
    NgxChartsModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyBFjh1plfxYmtD0OfyaQo0IAdGuaLf71vY"
    })
  ],

  providers: [UserLoginService, SignupService, HttpClientModule,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
