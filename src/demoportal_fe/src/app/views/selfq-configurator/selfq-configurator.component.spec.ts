import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelfqConfiguratorComponent } from './selfq-configurator.component';

describe('SelfqConfiguratorComponent', () => {
  let component: SelfqConfiguratorComponent;
  let fixture: ComponentFixture<SelfqConfiguratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelfqConfiguratorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelfqConfiguratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
