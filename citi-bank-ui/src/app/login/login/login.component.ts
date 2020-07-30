import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  email = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    sessionStorage.removeItem('login');
  }

  login() {
    this.http.get('/app/data/user').subscribe();
    let headers = { headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded') };
    let data = new HttpParams()
      .set('username', this.email)
      .set('password', this.password);
    this.http.post('/validateCredentials', data, headers).subscribe(value => {
      sessionStorage.setItem('login', btoa("YES"));
      this.router.navigate(['/home']);
    }, error => {
      alert("Email or password is incorrect");
    }
    );
  }

}
