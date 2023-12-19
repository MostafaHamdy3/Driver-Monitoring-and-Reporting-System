import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Driver } from '../Services/Driver';
import { Vehicle } from '../Services/Vehicle';

@Component({
  selector: 'app-profile-setting',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './profile-setting.component.html',
  styleUrl: './profile-setting.component.css'
})

export class ProfileSettingComponent implements OnInit {
  // TODO: Pass a driver and vehicle object
  constructor() { }
  @Input() driver: Driver;
  @Input() vehicle: Vehicle;

  firstName: string;
  lastName: string;
  job: string;
  email: string;
  phone: string;
  gender: string;

  vehicleName: string;
  model: string;
  OEM: string;
  license: string;
  creation: number;
  serial: String;

  ngOnInit(): void {
    this.firstName = this.driver.firstName;
    this.lastName = this.driver.lastName;
    this.job = this.driver.jobTitle;
    this.email = this.driver.email;
    this.phone = this.driver.phone;
    this.gender = this.driver.gender.toString();

    this.vehicleName = this.vehicle.name;
    this.model = this.vehicle.model;
    this.OEM = this.vehicle.oem;
    this.license = this.vehicle.licensePlate;
    this.creation = this.vehicle.creationYear;
    this.serial = this.vehicle.serialNumber;
  }


  onUpdateUser() {
    // this.serversService.updateServer(this.server.id, {});
  }
}
