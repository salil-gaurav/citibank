import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.sass']
})
export class TransferComponent implements OnInit {

  senderAccountId = '';
  receiverAccountId = '';
  amount;
  remarks;
  errors = {
    senderAccountId: [],
    receiverAccountId: [],
    amount: []
  };
  accounts: any = [];
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getAccounts();
  }

  transfer() {
    const data = {
      senderAccountId: this.senderAccountId,
      receiverAccountId: this.receiverAccountId,
      amount: this.amount,
      remarks: this.remarks
    };
    this.http.post('/app/data/transaction', data).subscribe(value => {
      this.clearFields();
      alert("Tranfer success!!!");
    }, errorReposne => {
      this.handlerError(errorReposne);
    })
  }

  getAccounts() {
    this.http.get('/app/data/account/list').subscribe(value => {
      this.accounts = value;
    });
  }

  handlerError(error) {
    if (error.status === 400) {
      this.genrateValidationErros(error.error.errors);
    } else {
      this.clearFields();
      alert(error.error);
    }
  }

  genrateValidationErros(errors) {
    errors.forEach(element => {
      this.errors[element.fieldName].push(element.message);
    });
  }

  clearFields() {
    this.senderAccountId = '';
    this.receiverAccountId = '';
    this.amount;
    this.remarks;
    this.errors = {
      senderAccountId: [],
      receiverAccountId: [],
      amount: []
    };
  }

}
