import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Trip } from '../models/Trip';
import { TripService } from '../Services/user-trip.service';
import { EventCardComponent } from '../event-card-component/event-card-component.component';
import { TotalEvents } from '../models/TotalEvents';

@Component({
  selector: 'app-trips-table',
  standalone: true,
  imports: [CommonModule, EventCardComponent],
  templateUrl: './trips-table.component.html',
  styleUrls: ['./trips-table.component.css'],
})
export class TripsTableComponent implements OnInit {
  tripDetails: Trip[] = [];
  tripEvents: TotalEvents = new TotalEvents();
  showTripCards: boolean = false;

  cardsData: Array<any> ;

  constructor(private tripData: TripService) {}

  ngOnInit() {
    this.onGetTrips();
  }

  onGetTrips() {
    this.tripData.getTrips().subscribe((data: Trip[]) => {
      this.tripDetails = data;
    });
  }

  onGetTripEvents(id: number) {
    this.tripData.getTripEvents(id).subscribe((data: TotalEvents) => {
      this.tripEvents = data;
      this.cardsData = [
        {
          imgSrc: '../../assets/aggressive-icon.png',
          imgAlt: 'aggressive',
          eventCount: this.tripEvents.suddenBraking,
          description: 'Sudden brake',
        },
        {
          imgSrc: '../../assets/aggressive-left-turn.png',
          imgAlt: 'aggressive-left-turn',
          eventCount: this.tripEvents.aggTL,
          description: 'Aggressive left',
        },
        {
          imgSrc: '../../assets/aggressive-right-turn.png',
          imgAlt: 'aggressive-right-turn',
          eventCount: this.tripEvents.aggTR,
          description: 'Aggressive right',
        },
        {
          imgSrc: '../../assets/swerve.png',
          imgAlt: 'swerve',
          eventCount: this.tripEvents.swerve,
          description: 'Aggressive swerve',
        },
        {
          imgSrc: '../../assets/speed.png',
          imgAlt: 'speed limit',
          eventCount: this.tripEvents.speedLimitViolation,
          description: 'Speed limit violation',
        },
        {
          imgSrc: '../../assets/road-sign.png',
          imgAlt: 'road-sign',
          eventCount: this.tripEvents.otherTrafficViolation,
          description: 'Other traffic sign',
        },
      ];
    });
    this.showTripCards = true;
  }
}
