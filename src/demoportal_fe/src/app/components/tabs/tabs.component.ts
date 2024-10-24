import { AfterContentInit, Component, ContentChildren, Input, QueryList, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrl: './tabs.component.css'
})
export class TabsComponent  {
  @Input() tabs: Array<{ title: string, content: TemplateRef<any> }> = [];

  selectedTabIndex = 0;

 

  selectTab(index: number) {
    this.selectedTabIndex = index;
  }
}
