import {Component, OnInit} from '@angular/core';
import {Transfer} from "../model/transfer";
import {Router} from "@angular/router";
import {TransferService} from "../services/TransferService";
import {Http, Headers, Response} from "@angular/http";
import {AuthService} from "../services/auth.service";

@Component({
    selector: 'transaction-verify',
    templateUrl: './transaction-verification.component.html',
    styleUrls: [ './transaction-verification.component.css' ]
})
export class TransactionVerificationComponent implements OnInit {

    private updateHeaders =
        new Headers({'Content-Type': 'application/json'});
    private url = 'http://localhost:8080/transfer';

    private transfer: Transfer;

    constructor(private http: Http,
                private router: Router,
                private transferService: TransferService,
                private authService: AuthService) {}

    ngOnInit(): void {
        console.log('initializing');
        this.transfer = this.transferService.getTransfer();
    }

    accept(){
        let options = {headers: this.updateHeaders};
        let url = this.url + '?username=' + this.authService.getUsername();
        this.http.post(url, this.transfer, options)
            .toPromise()
            .then((response: Response) => this.getTransfer(response))
            .then((retTransfer: Transfer) => {
                console.log(retTransfer);
                this.transferService.setTransfer(retTransfer);
                this.router.navigate(['/trres']);
            })
            .catch(this.handleError);
    }

    private getTransfer(response: Response) : Promise<Transfer> {
        return this.http.get(this.url + "/id?id=" + response.json())
            .toPromise()
            .then((response: Response) => response.json())
            .catch(this.handleError);
    }

    private handleError (error: Response | any) {
        console.error(error.message || error);
        return Promise.reject(error.message || error);
    }

    reject(){

    }
}
