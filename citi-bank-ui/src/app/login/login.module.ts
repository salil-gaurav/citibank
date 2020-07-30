import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { LoginRoutes } from './login.routes';
import { LoginHostComponent } from './login.host.component';



@NgModule({
  declarations: [LoginHostComponent, LoginComponent],
  imports: [
    RouterModule.forChild(LoginRoutes),
    CommonModule,
    FormsModule
  ]
})
export class LoginModule { }
