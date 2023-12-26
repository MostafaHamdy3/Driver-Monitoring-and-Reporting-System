import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Trip } from '../Services/Trip';
import { TripService } from '../Services/user-trip.service';

@Component({
  selector: 'app-trips-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './trips-table.component.html',
  styleUrls: ['./trips-table.component.css'],
})
export class TripsTableComponent implements OnInit {
  suddenBrake: number = 0;
  aggressiveLeft: number = 0;
  aggressiveRight: number = 0;
  aggressiveSwerve: number = 0;
  speedViolation: number = 0;
  totalOtherSign: number = 0;
  respondedOtherSign: number = 0;

  tripDetails: Trip[] = [];

  constructor(private tripData: TripService) {}

  ngOnInit() {
    this.onGetTrips();
  }

  onGetTrips() {
    this.tripData.getTrips().subscribe((data: Trip[]) => {
      this.tripDetails = data;
    });
  }
}
