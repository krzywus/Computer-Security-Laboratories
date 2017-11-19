import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'forbidden',
    templateUrl: './forbidden.component.html',
    styleUrls: [ './forbidden.component.css' ]
})
export class ForbiddenComponent {
    constructor(route: ActivatedRoute){
        console.log("Forbid:"  );
    }
}
