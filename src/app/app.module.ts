import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AgmCoreModule } from '@agm/core';
import { MatIconModule } from '@angular/material/icon';
import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { ProfileSettingComponent } from './profile-setting/profile-setting.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    DashboardComponent,
    ProfileSettingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MatIconModule,
    routes,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyBFjh1plfxYmtD0OfyaQo0IAdGuaLf71vY"
    })
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
