import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CenterService {
  uri = 'http://localhost:8080/center';
  reloadData: any;

  constructor(private http: HttpClient) { }

  getCenter() {
    return this.http.get(`${this.uri}`);
  }

  getCenterById(id: number) {
    return this.http.get(`${this.uri}/${id}`);
  }

  pushFileToStorage(file: File, name:string): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
 
    formdata.append('file', file);
    formdata.append('name', name);
 
    const req = new HttpRequest('POST', 'http://localhost:8080/center/file/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });
 
    return this.http.request(req);
  }

  
}
