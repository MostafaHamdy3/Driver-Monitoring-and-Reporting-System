import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AgmCoreModule } from '@agm/core';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyBFjh1plfxYmtD0OfyaQo0IAdGuaLf71vY"
    })
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
