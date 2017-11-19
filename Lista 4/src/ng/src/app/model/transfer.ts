export class Transfer {
    recipient: string;
    account: string;
    amount: string;
    title: string;


    constructor(recipient: string, account: string, amount: string, title: string) {
        this.recipient = recipient;
        this.account = account;
        this.amount = amount;
        this.title = title;
    }
}