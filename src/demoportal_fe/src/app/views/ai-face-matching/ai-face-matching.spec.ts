import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AiFaceMatchingComponent } from './ai-face-matching.component';

describe('AiFaceMatchingComponent', () => {
  let component: AiFaceMatchingComponent;
  let fixture: ComponentFixture<AiFaceMatchingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AiFaceMatchingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AiFaceMatchingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
