import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentRecognitionComponent } from './document-recognition.component';

describe('DocumentRecognitionComponent', () => {
  let component: DocumentRecognitionComponent;
  let fixture: ComponentFixture<DocumentRecognitionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DocumentRecognitionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocumentRecognitionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
