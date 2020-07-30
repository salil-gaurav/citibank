import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class HomeGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot) {
        if (atob(sessionStorage.getItem('login')) === 'YES') {
            return true;
        } else {
            return false;
        }
    }

}