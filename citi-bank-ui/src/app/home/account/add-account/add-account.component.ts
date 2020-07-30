import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.sass']
})
export class AddAccountComponent implements OnInit {

  accountType = '';
  amount = 0;
  accountName = '';
  errors = {
    accountType: [],
    accountName: []
  };

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  create() {
    const data = {
      accountType: this.accountType == '' ? null : this.accountType,
      currentMoney: {
        amount: this.amount || 0,
        currency: 'USD'
      },
      accountName: this.accountName.trim()
    };

    this.http.post('/app/data/account', data).pipe(tap(
      data => {
        this.resetError();
        this.clearFields();
        alert("Account created !!!");
      },
      error => {
        this.handlerError(error);
      }
    )).subscribe();
  }

  handlerError(error) {
    if (error.status === 400) {
      this.genrateValidationErros(error.error.errors);
    }
  }

  genrateValidationErros(errors) {
    errors.forEach(element => {
      this.errors[element.fieldName].push(element.message);
    });
  }

  resetError() {
    this.errors = {
      accountType: [],
      accountName: []
    }
  }

  clearFields() {
    this.accountType = '';
    this.amount = 0;
    this.accountName = '';
    this.errors = {
      accountType: [],
      accountName: []
    };
  }

}
