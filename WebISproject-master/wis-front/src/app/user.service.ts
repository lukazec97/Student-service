import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  uri = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }

  getAllUsers() {
    return this.http.get(`${this.uri}`);
  }
}
