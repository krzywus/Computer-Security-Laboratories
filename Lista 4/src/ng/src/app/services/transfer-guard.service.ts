import { Injectable }       from '@angular/core';
import {
    CanActivate, Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
} from '@angular/router';
import { AuthService }      from './auth.service';

@Injectable()
export class TransferGuard implements CanActivate {
    transaction: boolean;

    constructor(private authService: AuthService, private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let url: string = state.url;
        console.log(url);

        return this.checkLogin(url) && this.transactionPending();
    }

    checkLogin(url: string): boolean {
        if (this.authService.isLoggedIn) { return true; }

        this.authService.redirectUrl = url;

        this.router.navigate(['/trform']);
        return false;
    }

    private transactionPending() {
        return this.transaction;
    }

    setTransactionPending(transactionPending: boolean) {
        this.transaction = transactionPending;
    }
}