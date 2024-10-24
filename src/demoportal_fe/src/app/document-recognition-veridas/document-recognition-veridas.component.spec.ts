import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentRecognitionVeridasComponent } from './document-recognition-veridas.component';

describe('DocumentRecognitionVeridasComponent', () => {
  let component: DocumentRecognitionVeridasComponent;
  let fixture: ComponentFixture<DocumentRecognitionVeridasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DocumentRecognitionVeridasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocumentRecognitionVeridasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
