import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class AdminService {

    uri = 'http://localhost:8080/admin';
    reloadData: any;
    constructor(private http: HttpClient) { }

    getAdmin() {
        return this
            .http
            .get(`${this.uri}`);
    }
}
