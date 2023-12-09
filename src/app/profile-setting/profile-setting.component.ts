import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile-setting',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile-setting.component.html',
  styleUrl: './profile-setting.component.css'
})

export class ProfileSettingComponent implements OnInit {
  constructor() { }

  userDetails: {
    id: number,
    firstName: string,
    lastName: string,
    job: string,
    email: string
  };
  vehicleInfo: {
    vehicle: string,
    model: string,
    license: string,
    creation: number
  };

  firstName = "Mostafa";
  lastName = "Hamdy";
  job = "Software Engineer";
  email = "mostafa@gmail.com";

  vehicle = "";
  model = "";
  license = "";
  creation = 2016;

  ngOnInit(): void {

  }

  onUpdateUser() {
    // this.serversService.updateServer(this.server.id, {});
  }
}
