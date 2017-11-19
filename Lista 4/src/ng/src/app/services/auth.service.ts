import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import {Http, Response} from "@angular/http";

@Injectable()
export class AuthService {
    isLoggedIn = false;

    redirectUrl: string;
    private username: string;


    constructor(private http: Http) {
    }

    login(username: string, password: string) {
        let url = 'http://localhost:8080/login?username='
            + username + '&password=' + password;
        this.username = username;
        return this.http.post(url, [])
                .toPromise()
                .then((response : Response) => {
                    this.isLoggedIn = response.json();
                    return this.isLoggedIn;
                });
    }

    logout(): void {
        this.isLoggedIn = false;
    }

    getUsername() {
        return this.username;
    }
}