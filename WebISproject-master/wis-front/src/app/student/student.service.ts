import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  uri = 'http://localhost:8080/student';
  adminUri = 'http://localhost:8080/admin';
  reloadData: any;
  authKey: string;

  constructor(private http: HttpClient) { }

  addStudent(firstname, lastname, cardnumber, password) {
    const obj = {
      firstName: firstname,
      lastName: lastname,
      cardNumber: cardnumber,
      pass: password
    };
    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
  }

  getStudents() {
    return this
           .http
           .get(`${this.uri}`);
  }

  editStudent(id) {
    return this
            .http
            .get(`${this.uri}/${id}`);
    }
    updateStudent(firstname, lastname, CardNumber, id) {

      const obj = {
          firstName: firstname,
          lastName: lastname,
          cardNumber: CardNumber
};
      this
        .http
        .put(`${this.uri}/update/${id}`, obj)
        .subscribe(res => console.log('Done'));
    }

    deleteStudent(id: number): Observable<any> {
      return this.http.delete(`${this.uri}/${id}`, { responseType: 'text' });
    }

    getStudentByFirstName(firstName: string): Observable<any> {
      return this.http.get(`${this.uri}/firstname/${firstName}`);
    }

    getStudentByLastName(lastName: string): Observable<any> {
      return this.http.get(`${this.uri}/lastname/${lastName}`);
    }

    searchStudent(name: string): Observable<any> {
      return this.http.get(`${this.uri}/search/${name}`);
    }

    logInStudent(cardNumber: string, password: string)
    {

      const obj = 
      {
        card: cardNumber,
        pass: password

      };

      this.http.post(`${this.uri}/login`, obj).subscribe(res => console.log('Done'));
    }

    enrollStudent(id:number, spId:number)
    {
      this.http.post(`${this.uri}/upisnaprvu/${spId}`, id).subscribe(res => console.log('Done'));
    }

    enrollStudentNext(id:number)
    {
      this.http.post(`${this.adminUri}/upis`, id).subscribe(res => console.log('Done'));
    }


    getXML(id) {

     
      
      return this.http.get(`${this.uri}/downloadxml/${id}`, {responseType: 'blob'} );
    }

    getAllXML()
    {
      return this.http.get(`${this.uri}/downloadxml`, {responseType: 'blob'} );
    }

    getPDF(id) {

     
      
      return this.http.get(`${this.uri}/downloadpdf/${id}`, {responseType: 'blob'} );
    }
    getAllPDF() {

     
      
      return this.http.get(`${this.uri}/downloadpdf/`, {responseType: 'blob'} );
    }

}
