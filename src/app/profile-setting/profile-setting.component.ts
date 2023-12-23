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
  driverDetails: Driver;
  vehicleDetails: Vehicle;
  updatedDeriver: boolean = false;
  updatedVehicle: boolean = false;

  constructor(private driverService: DriverVehicleService) {}

  ngOnInit() {
    this.driverDetails = this.driverService.driverDetails;
    this.vehicleDetails = this.driverService.vehicleDetails;
    console.log(this.driverDetails)
  }

  onUpdateDriverData() {
    this.driverService.updateDriver(this.driverDetails).subscribe(() => {
      console.log("Updated driver successfully");
      this.updatedDeriver = true;
      setInterval(() => {
        this.updatedDeriver = false;
      }, 2000);
    }, (err) => {
      console.log("Failed to update driver");
      this.updatedDeriver = false;
    })
  }

  onUpdateVehicleData() {
    this.driverService.updateVehicle(this.vehicleDetails).subscribe(() => {
      console.log("Updated vehicle successfully");
      this.updatedVehicle = true;
      setInterval(() => {
        this.updatedVehicle = false;
      }, 2000);
    }, (err) => {
      console.log("Failed to update vehicle");
      this.updatedDeriver = false;
    })
  }
}
