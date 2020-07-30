import { Route } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginHostComponent } from './login.host.component';

export const LoginRoutes: Route[] = [
    {
        path: '',
        component: LoginHostComponent,
        children: [
            {
                path: '',
                component: LoginComponent
            }
        ]
    }
];