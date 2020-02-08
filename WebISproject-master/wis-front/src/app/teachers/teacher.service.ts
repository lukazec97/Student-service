import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  uri = 'http://localhost:8080/teacher';
  reloadData: any;

  constructor(private http: HttpClient) { }

  addTeacher(firstname, lastname, personalIdentificationNumber) {
    const obj = {
      firstName: firstname,
      lastName: lastname,
      personalIdentificationNumber : personalIdentificationNumber
    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getTeachers() {
    return this
           .http
           .get(`${this.uri}`);
  }

  editTeacher(id) {
    return this
            .http
            .get(`${this.uri}/${id}`);
    }

    updateTeacher(firstname, lastname, personalIdentificationnumber, id) {

      const obj = {
          firstName: firstname,
          lastName: lastname,
          personalIdentificationNumber : personalIdentificationnumber
};
      this
        .http
        .put(`${this.uri}/update/${id}`, obj)
        .subscribe(res => console.log('Done'));
    }

    deleteTeacher(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    getTeacherByFirstName(firstName: string): Observable<any> {
      return this.http.get(`${this.uri}/firstname/${firstName}`);
    }

    getPDF(id) {

     
      
      return this.http.get(`${this.uri}/downloadpdf/${id}`, {responseType: 'blob'} );
    }
    getAllPDF() {

     
      
      return this.http.get(`${this.uri}/downloadpdf/`, {responseType: 'blob'} );
    }

    getXML(id) {

     
      
      return this.http.get(`${this.uri}/downloadxml/${id}`, {responseType: 'blob'} );
    }

    getAllXML()
    {
      return this.http.get(`${this.uri}/downloadxml`, {responseType: 'blob'} );
    }
}
