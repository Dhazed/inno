import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnWidgetConfiguratorComponent } from './on-widget-configurator.component';

describe('OnWidgetConfiguratorComponent', () => {
  let component: OnWidgetConfiguratorComponent;
  let fixture: ComponentFixture<OnWidgetConfiguratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OnWidgetConfiguratorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OnWidgetConfiguratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
