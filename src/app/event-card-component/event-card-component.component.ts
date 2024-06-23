import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-card-component.component.html',
  styleUrl: '../dashboard/dashboard.component.css',
})
export class EventCardComponent implements OnChanges {
  @Input('CardDataProps') cardDataProps: CardDetails;
  cardData: CardDetails;

  ngOnChanges() {

    this.cardData = this.cardDataProps;
  }
}

interface CardDetails {
  imgSrc: string;
  imgAlt: string;
  eventCount: number;
  description: string;
}
