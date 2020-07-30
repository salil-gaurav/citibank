import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-account',
  templateUrl: './list-account.component.html',
  styleUrls: ['./list-account.component.sass']
})
export class ListAccountComponent implements OnInit {

  accounts: any = [];
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.getAccount();
  }

  getAccount() {
    this.http.get('/app/data/account/list').subscribe(value => {
      this.accounts = value;
    });
  }

  delete(accountId) {
    this.http.delete(`/app/data/account?accountId=${accountId}`).subscribe(() => {
      this.getAccount();
      alert("Account deleted!!!");
    })
  }

  go(accountId) {
    this.router.navigate([`/home/account/view/${accountId}`]);
  }

}
