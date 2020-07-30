import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-account',
  templateUrl: './view-account.component.html',
  styleUrls: ['./view-account.component.sass']
})
export class ViewAccountComponent implements OnInit {

  accountId;
  account;
  transaction: any = [];
  constructor(private http: HttpClient, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.accountId = this.activateRoute.snapshot.params.accountId;
    this.getAccount();
    this.getTransaction();
  }

  getAccount() {
    this.http.get(`/app/data/account?accountId=${this.accountId}`).subscribe(value => {
      if (value) {
        this.account = value;
      }
    })
  }

  getTransaction() {
    this.http.get(`/app/data/transaction?accountId=${this.accountId}`).subscribe(value => {
      if (value) {
        this.transaction = value;
      }
    })
  }

}
