import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-gauge',
  templateUrl: './gauge.component.html',
  styleUrls: ['./gauge.component.css']
})
export class GaugeComponent implements OnChanges {
  @Input() currentValue: number = 0;  
  @Input() gaugeText: string = '0%';
  @Input() gaugeMatch: boolean = false;
  circumference = 100; 
  dashArray: string = '0, 100'; 
  
  ngOnChanges(changes: SimpleChanges) {
    if (changes['currentValue']) {
      const value = Math.min(Math.max(this.currentValue, 0), 100);
      this.dashArray = `${(value / 100) * this.circumference}, ${this.circumference}`;
    }
  }

}
