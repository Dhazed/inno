import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-step-counter',
  templateUrl: './step-counter.component.html',
  styleUrls: ['./step-counter.component.css']
})
export class StepCounterComponent {
  @Input() steps:Array<{name:string}> = [];

  @Input() currentStep = 1;

  goToStep(stepNumber: number) {
    if (stepNumber > 0 && stepNumber <= this.steps.length) {
      this.currentStep = stepNumber;
    }
  }
}
