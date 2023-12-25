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
  styleUrl: './profile-setting.component.css',
})
export class ProfileSettingComponent implements OnInit {
  driverDetails: Driver = new Driver();
  vehicleDetails: Vehicle = new Vehicle();
  updatedDeriver: boolean = false;
  updatedVehicle: boolean = false;

  constructor(private driverService: DriverVehicleService) {}

  ngOnInit() {
    this.onGetDriverData();
    this.onGetVehicleData();
    // this.driverDetails = this.driverService.driverDetails;
    // this.vehicleDetails = this.driverService.vehicleDetails;
    // console.log(this.driverDetails);
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
        console.log('Updated driver successfully');
        this.updatedDeriver = true;
        setInterval(() => {
          this.updatedDeriver = false;
        }, 2000);
      },
      (err) => {
        console.log('Failed to update driver');
        this.updatedDeriver = false;
      }
    );
  }

  onUpdateVehicleData() {
    this.driverService.updateVehicle(this.vehicleDetails).subscribe(
      () => {
        console.log('Updated vehicle successfully');
        this.updatedVehicle = true;
        setInterval(() => {
          this.updatedVehicle = false;
        }, 2000);
      },
      (err) => {
        console.log('Failed to update vehicle');
        this.updatedDeriver = false;
      }
    );
  }
}
