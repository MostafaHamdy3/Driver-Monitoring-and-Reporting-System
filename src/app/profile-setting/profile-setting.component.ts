import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-profile-setting',
  standalone: true,
  imports: [CommonModule, FormsModule],
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
    creation: number,
    serial: number,
  };

  firstName = "Mostafa";
  lastName = "Hamdy";
  job = "Software Engineer";
  email = "mostafa@gmail.com";

  vehicle = "BlueSky Cruiser";
  model = "EcoGlide Deluxe";
  license = "ABC 1234";
  creation = 2021;
  serial= 0;

  ngOnInit(): void {

  }

  onUpdateUser() {
    // this.serversService.updateServer(this.server.id, {});
  }
}
