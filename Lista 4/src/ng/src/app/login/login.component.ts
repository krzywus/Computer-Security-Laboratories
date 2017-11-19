import {Component} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: [ './login.component.css' ]
})
export class LoginComponent {

    constructor(private authService: AuthService,
                private router: Router) {}

    login(username: string, password: string) {
        this.authService.login(username, password)
                .then(
                    (isValid: boolean) => {
                        console.log(isValid);
                        if (isValid) {
                            this.router.navigate(['/trform']);
                        } else {
                            this.router.navigate(['/login']);
                        }
                    }
                );
    }
}
