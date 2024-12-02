import { Component, OnInit } from '@angular/core';
import { OnboardingWidgetService } from '../../services/onboarding-widget.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-onboarding-widget-page',
  templateUrl: './onboarding-widget-page.component.html',
  styleUrl: './onboarding-widget-page.component.css'
})
export class OnboardingWidgetPageComponent implements OnInit {
  onWidgetToken = '';
  customStyles = {};
  showWidget = false;
  constructor(private onWidgetService: OnboardingWidgetService,
    private route: ActivatedRoute,
    private router: Router) { }


  ngOnInit(): void {
    const sessionId = this.route.snapshot.queryParamMap.get('sessionId');
    const customStylesBase64 = this.route.snapshot.queryParamMap.get('customStyles') || '';
    if (customStylesBase64) {
      const customStylesString = atob(customStylesBase64);
      this.customStyles = JSON.parse(customStylesString);
      console.log(this.customStyles);
    }
    if (!sessionId) {
      this.router.navigate(['/']);
    } else {
      this.onWidgetService.getRefreshToken(sessionId).subscribe((res: any) => {
        this.onWidgetToken = res.token;
        this.showWidget = true;
      });
    }

  }


}