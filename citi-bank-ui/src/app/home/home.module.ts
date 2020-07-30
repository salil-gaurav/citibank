import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HomeRoutes } from './home.routes';
import { ProfileComponent } from './profile/profile.component';
import { AccountComponent } from './account/account.component';
import { TransferComponent } from './transfer/transfer.component';
import { AddAccountComponent } from './account/add-account/add-account.component';
import { ListAccountComponent } from './account/list-account/list-account.component';
import { ViewAccountComponent } from './account/view-account/view-account.component';
import { LanderComponent } from './lander/lander.component';



@NgModule({
  declarations: [HomeComponent, ProfileComponent, AccountComponent, TransferComponent, AddAccountComponent, ListAccountComponent, ViewAccountComponent, LanderComponent],
  imports: [
    RouterModule.forChild(HomeRoutes),
    FormsModule,
    CommonModule
  ]
})
export class HomeModule { }
