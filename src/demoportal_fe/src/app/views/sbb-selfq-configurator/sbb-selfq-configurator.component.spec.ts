import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SBBSelfqConfiguratorComponent } from './sbb-selfq-configurator.component';

describe('SBBSelfqConfiguratorComponent', () => {
  let component: SBBSelfqConfiguratorComponent;
  let fixture: ComponentFixture<SBBSelfqConfiguratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SBBSelfqConfiguratorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SBBSelfqConfiguratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
