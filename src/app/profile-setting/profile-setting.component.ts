import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Driver } from '../models/Driver';
import { Vehicle } from '../models/Vehicle';
import { DataService } from '../Services/user-data.service';

@Component({
  selector: 'app-profile-setting',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './profile-setting.component.html',
  styleUrl: './profile-setting.component.css',
})
export class ProfileSettingComponent implements OnInit {
  driverDetails: Driver = new Driver();
  vehicleDetails: Vehicle = new Vehicle();
  updatedDeriver: boolean = false;
  updatedVehicle: boolean = false;

  constructor(private driverService: DataService) {}

  ngOnInit() {
    this.onGetDriverData();
    this.onGetVehicleData();
  }

  onGetDriverData() {
    this.driverService.getDriver().subscribe((driver: Driver) => {
      console.log(driver);
      this.driverDetails.id = driver.id;
      this.driverDetails.firstName = driver.firstName;
      this.driverDetails.lastName = driver.lastName;
      this.driverDetails.jobTitle = driver.jobTitle;
      this.driverDetails.email = driver.email;
      this.driverDetails.phone = driver.phone;
      this.driverDetails.gender = driver.gender;
      // this.driverService.updateDriverDetails(driver);
    });
  }

  onGetVehicleData() {
    this.driverService.getVehicle().subscribe((vehicle: Vehicle) => {
      console.log(vehicle);
      this.vehicleDetails.id = vehicle.id;
      this.vehicleDetails.name = vehicle.name;
      this.vehicleDetails.model = vehicle.model;
      this.vehicleDetails.oem = vehicle.oem;
      this.vehicleDetails.licensePlate = vehicle.licensePlate;
      this.vehicleDetails.creationYear = vehicle.creationYear;
      this.vehicleDetails.serialNumber = vehicle.serialNumber;
      // this.driverService.updateDriverDetails(vehicle);
    });
  }

  onUpdateDriverData() {
    this.driverService.updateDriver(this.driverDetails).subscribe(
      () => {
        this.updatedDeriver = true;
        setInterval(() => {
          this.updatedDeriver = false;
        }, 2000);
      },
      (err) => {
        this.updatedDeriver = false;
      }
    );
  }

  onUpdateVehicleData() {
    this.driverService.updateVehicle(this.vehicleDetails).subscribe(
      () => {
        this.updatedVehicle = true;
        setInterval(() => {
          this.updatedVehicle = false;
        }, 2000);
      },
      (err) => {
        this.updatedDeriver = false;
      }
    );
  }
}
