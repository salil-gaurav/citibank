import { Route } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { RegisterHostComponent } from './register.host.component';

export const RegisterRoutes: Route[] = [
    {
        path: '',
        component: RegisterHostComponent,
        children: [
            {
                path: '',
                component: RegisterComponent
            }
        ]
    }
];