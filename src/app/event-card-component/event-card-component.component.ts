import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-card-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-card-component.component.html',
  styleUrl: '../dashboard/dashboard.component.css',
})
export class EventCardComponentComponent {
  @Input() imgSrc: string;
  @Input() imgAlt: string;
  @Input() eventCount: number;
  @Input() description: string;
}
