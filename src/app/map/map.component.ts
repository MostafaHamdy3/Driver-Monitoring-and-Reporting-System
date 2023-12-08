import { Component, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-map',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  schemas: [NO_ERRORS_SCHEMA],
  templateUrl: './map.component.html',
  styleUrl: './map.component.css'
})

export class MapComponent {
  lat: number = 29.4;
  lng: number = 30.57;
  lat2: number = 28.4;
  lng2: number = 31.57;
  zoom: number = 18;
}
