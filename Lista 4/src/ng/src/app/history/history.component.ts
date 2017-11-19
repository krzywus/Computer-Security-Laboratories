import {Component, OnInit} from '@angular/core';
import {Http} from "@angular/http";
import {Transfer} from "../model/transfer";
import {AuthGuard} from "../services/AuthGuard";
import {AuthService} from "../services/auth.service";

@Component({
    selector: 'history',
    templateUrl: './history.component.html',
    styleUrls: [ './history.component.css' ]
})
export class HistoryComponent {
    transactions: Transfer[];

    private url = 'http://localhost:8080/transfer';
    constructor(private http: Http,
                private authService: AuthService) {
        this.fetchData();
    }

    fetchData(){
        let promise: Promise<Transfer[]> =
            this.http.get(this.url + "/all?username=" + this.authService.getUsername())
            .toPromise()
            .then(response => response.json() as Transfer[])
            .then((transactions: Transfer[]) =>
                this.transactions = transactions)
            .catch(this.handleError);
    }

    private handleError (error: Response | any) {
        console.error(error.message || error);
        return Promise.reject(error.message || error);
    }
}
