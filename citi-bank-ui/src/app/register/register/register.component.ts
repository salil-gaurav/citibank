import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {
  email = '';
  firstName = '';
  lastName = '';
  phoneNumber = '';
  address = '';
  ssn = '';
  password = ''
  errors = {
    "user.email": [],
    "user.firstName": [],
    "user.lastName": [],
    "user.phoneNumber": [],
    "user.address": [],
    "user.ssn": [],
    "password": []
  };

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  register() {
    const data = {
      user: {
        email: this.email,
        firstName: this.firstName,
        lastName: this.lastName,
        address: this.address,
        phoneNumber: this.phoneNumber,
        ssn: this.ssn
      },
      password: this.password
    };
    this.http.post('/register', data).subscribe(value => {

    }, errorResponse => {
      if (errorResponse.status === 400) {
        this.genrateValidationErros(errorResponse.error.errors);
      }
    });
  }

  genrateValidationErros(errors) {
    errors.forEach(element => {
      this.errors[element.fieldName].push(element.message);
    });
  }
}
