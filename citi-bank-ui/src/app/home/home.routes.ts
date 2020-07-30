import { Route } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { TransferComponent } from './transfer/transfer.component';
import { AccountComponent } from './account/account.component';
import { ListAccountComponent } from './account/list-account/list-account.component';
import { ViewAccountComponent } from './account/view-account/view-account.component';
import { AddAccountComponent } from './account/add-account/add-account.component';
import { LanderComponent } from './lander/lander.component';
import { HomeGuard } from './home.guard';

export const HomeRoutes: Route[] = [
    {
        path: '',
        component: HomeComponent,
        canActivate: [HomeGuard],
        children: [
            {
                path: '',
                component: LanderComponent
            },
            {
                path: 'profile',
                component: ProfileComponent
            },
            {
                path: 'transfer',
                component: TransferComponent
            },
            {
                path: 'account',
                component: AccountComponent,
                children: [
                    {
                        path: 'list',
                        component: ListAccountComponent
                    },
                    {
                        path: 'view/:accountId',
                        component: ViewAccountComponent
                    },
                    {
                        path: 'add',
                        component: AddAccountComponent
                    }
                ]
            }
        ]
    }
];