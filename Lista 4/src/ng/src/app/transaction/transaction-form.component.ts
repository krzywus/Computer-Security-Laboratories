import {Component} from '@angular/core';
import {Transfer} from "../model/transfer";
import {TransferService} from "../services/TransferService";
import {Router} from "@angular/router";

@Component({
    selector: 'transaction-form',
    templateUrl: './transaction-form.component.html',
    styleUrls: [ './transaction-form.component.css' ]
})
export class TransactionFormComponent {

    constructor(private transferService: TransferService,
                private router : Router) {}

    send(recipient: string, account: string, amount: string, title: string) {
        this.transferService.setTransfer(new Transfer(recipient, account, amount, title));
        this.router.navigate(['/trver']);
    }
}
