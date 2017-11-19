import {Component, OnInit} from '@angular/core';
import {Http} from "@angular/http";
import {Transfer} from "../model/transfer";
import {Router} from "@angular/router";
import {TransferService} from "../services/TransferService";

@Component({
    selector: 'transaction-result',
    templateUrl: './transaction-result.component.html',
    styleUrls: [ './transaction-result.component.css' ]
})
export class TransactionResultComponent implements OnInit {

    private transfer: Transfer;

    constructor(private transferService: TransferService) {}

    ngOnInit(): void {
        this.transfer = this.transferService.getTransfer();
        this.transferService.setTransfer(null);
    }
}
