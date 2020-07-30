import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { RegisterHostComponent } from './register.host.component';
import { RegisterRoutes } from './register.routes';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [RegisterComponent, RegisterHostComponent],
  imports: [
    RouterModule.forChild(RegisterRoutes),
    CommonModule,
    FormsModule
  ]
})
export class RegisterModule { }
