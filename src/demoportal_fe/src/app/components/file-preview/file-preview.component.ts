import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-file-preview',
  templateUrl: './file-preview.component.html',
  styleUrl: './file-preview.component.css'
})
export class FilePreviewComponent {
 @Input() imageSrc = '';
 @Input() fileName = '';

}
