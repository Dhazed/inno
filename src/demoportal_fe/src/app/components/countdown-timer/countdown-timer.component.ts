import { Component, OnInit, OnDestroy, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit, OnDestroy {
  @Input() timeInSeconds: number = 180;
  timeLeft: number = 0;
  minutes: number = 0;
  seconds: number = 0;
  interval: any;
  @Output() timerEnd = new EventEmitter();

  ngOnInit(): void {
    this.timeLeft = this.timeInSeconds;
    this.updateTimeDisplay();
    this.startTimer();
  }

  ngOnDestroy(): void {
    if (this.interval) {
      clearInterval(this.interval);
    }
  }

  startTimer() {
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
        this.updateTimeDisplay();
      } else {
        clearInterval(this.interval);
        this.timerEnd.emit();
      }
    }, 1000);
  }


  updateTimeDisplay() {
    this.minutes = Math.floor(this.timeLeft / 60);
    this.seconds = this.timeLeft % 60;
  }
}
