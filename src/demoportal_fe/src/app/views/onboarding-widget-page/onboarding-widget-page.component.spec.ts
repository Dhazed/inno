import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnboardingWidgetPageComponent } from './onboarding-widget-page.component';

describe('OnboardingWidgetPageComponent', () => {
  let component: OnboardingWidgetPageComponent;
  let fixture: ComponentFixture<OnboardingWidgetPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OnboardingWidgetPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OnboardingWidgetPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
