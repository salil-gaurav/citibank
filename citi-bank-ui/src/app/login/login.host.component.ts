import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'login-host',
  template: '<div class="d-flex justify-content-center"><router-outlet></router-outlet></div>'
})
export class LoginHostComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
