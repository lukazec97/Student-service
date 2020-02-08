import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  uri = 'http://localhost:8080/register';

  

  constructor(private http: HttpClient) { }

  registerStudent(username: string, password: string, role: string, firstname: string, lastname: string, cardnumber:string) {
    
    let objectToSend = {"username": username, "password": password, "role": role, "firstname": firstname, "lastname": lastname, "cardnumber": cardnumber};
    this.http.post(`${this.uri}/student`, objectToSend).subscribe(res => {
      console.log(res);
    })
  }

  registerTeacher(username: string, password: string, role: string, firstname: string, lastname: string, personalid: string) {
    let objectToSend = {"username": username, "password": password, "role": role, "firstname": firstname, "lastname": lastname, "personalid": personalid};
    this.http.post(`${this.uri}/teacher`, objectToSend).subscribe(res => {
      console.log(res);
    })
  }

  registerAdmin(username: string, password: string, role: string, firstname: string, lastname: string) {
    let objectToSend = {"username": username, "password": password, "role": role, "firstname": firstname, "lastname": lastname};
    this.http.post(`${this.uri}/admin`, objectToSend).subscribe(res => {
      console.log(res);
    })
  }
}
