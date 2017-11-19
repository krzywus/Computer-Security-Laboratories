import { Injectable } from '@angular/core';
import {Transfer} from "../model/transfer";
import {TransferGuard} from "./transfer-guard.service";

@Injectable()
export class TransferService {
    private transfer: Transfer;

    constructor(private transferGuard: TransferGuard) { }

    setTransfer(transfer: Transfer) {
        this.transfer = transfer;
        this.transferGuard.setTransactionPending(this.transfer != null);
    }

    getTransfer() : Transfer {
        return this.transfer;
    }
}