import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompaniesSettingsComponent } from './companies-settings.component';

describe('CompaniesSettingsComponent', () => {
  let component: CompaniesSettingsComponent;
  let fixture: ComponentFixture<CompaniesSettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompaniesSettingsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompaniesSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
