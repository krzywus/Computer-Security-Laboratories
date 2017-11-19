import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {LoginComponent} from "./login/login.component";
import {TransactionFormComponent} from "./transaction/transaction-form.component";
import {TransactionVerificationComponent} from "./transaction/transaction-verification.component";
import {TransactionResultComponent} from "./transaction/transaction-result.component";
import {HistoryComponent} from "./history/history.component";
import {ForbiddenComponent} from "./403/forbidden.component";
import {AuthGuard} from "./services/AuthGuard";
import {buildPath} from "selenium-webdriver/http";
import {TransferGuard} from "./services/transfer-guard.service";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'trform',  component: TransactionFormComponent, canActivate: [AuthGuard]},
  { path: 'trver',  component: TransactionVerificationComponent,canActivate: [TransferGuard] },
  { path: 'trres',  component: TransactionResultComponent,canActivate: [TransferGuard] },
  { path: 'history',  component: HistoryComponent, canActivate: [AuthGuard] },
  { path: '403',  component: ForbiddenComponent },
  { path: '**', redirectTo: '/403', pathMatch: 'full' },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ,
  RouterModule.forChild(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
