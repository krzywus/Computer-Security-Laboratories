import { Component }          from '@angular/core';

@Component({
    selector: 'app-root',
    template: `
    <h1>{{title}}</h1>
    <nav>
        <a routerLink="/trform" routerLinkActive="active" style="margin:1%">
            New transfer</a>
        <a routerLink="/history" routerLinkActive="active">
            History</a>
    </nav>
    <router-outlet></router-outlet>
  `,
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = "BKL4";
}
