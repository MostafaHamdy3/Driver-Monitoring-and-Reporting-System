import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Driver } from '../Services/Driver';
import { Vehicle } from '../Services/Vehicle';
import { DriverVehicleService } from '../Services/user-data.service';

@Component({
  selector: 'app-profile-setting',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './profile-setting.component.html',
  styleUrl: './profile-setting.component.css'
})

export class ProfileSettingComponent implements OnInit {
  driverDetails: Driver = new Driver();
  vehicleDetails: Vehicle = new Vehicle();
  updatedDeriver: boolean = false;
  updatedVehicle: boolean = false;
  // firstName: string;
  // lastName: string;
  // job: string;
  // email: string;
  // phone: string;
  // gender: any;

  // vehicleName: string;
  // model: string;
  // OEM: string;
  // license: string;
  // creation: number;
  // serial: String;

  token: string = localStorage.getItem('token');
  constructor(private driverData: DriverVehicleService) {}

  ngOnInit() {
    this.onGetDriverData();
    this.onGetVehicleData();
  }

  onGetDriverData() {
    this.driverData.getDriver().subscribe((driver : Driver) => {
      console.log(driver);
      this.driverDetails.id = driver.id;
      this.driverDetails.firstName = driver.firstName;
      this.driverDetails.lastName = driver.lastName;
      this.driverDetails.jobTitle = driver.jobTitle;
      this.driverDetails.email = driver.email;
      this.driverDetails.phone = driver.phone;
      this.driverDetails.gender = driver.gender;
    })
  }

  onGetVehicleData() {
    this.driverData.getVehicle().subscribe((vehicle : Vehicle) => {
      console.log(vehicle);
      this.vehicleDetails.name = vehicle.name;
      this.vehicleDetails.model = vehicle.model;
      this.vehicleDetails.oem = vehicle.oem;
      this.vehicleDetails.licensePlate = vehicle.licensePlate;
      this.vehicleDetails.creationYear = vehicle.creationYear;
      this.vehicleDetails.serialNumber = vehicle.serialNumber;
    })
  }

  onUpdateDriverData() {
    this.driverData.updateDriver(this.driverDetails).subscribe(() => {
      console.log("Updated driver successfully");
      this.updatedDeriver = true;
    }, (err) => {
      console.log("Failed to update driver");
    })
  }

  onUpdateVehicleData() {
    this.driverData.updateVehicle(this.vehicleDetails).subscribe(() => {
      console.log("Updated vehicle successfully");
      this.updatedVehicle = true;
    }, (err) => {
      console.log("Failed to update vehicle");
    })
  }
}
