import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import Center from '../centers/Center';


@Injectable({
  providedIn: 'root'
})
export class StudyProgramService {

  uri = 'http://localhost:8080/studyprogram';
  private Center_URL = "http://localhost:8080\\center";
  reloadData: any;

  constructor(private http: HttpClient) { }

  getStudyProgram() {
    return this
           .http
           .get(`${this.uri}`);
  }

  getStudyProgramByName(name: string): Observable<any> {
    return this.http.get(`${this.uri}/name/${name}`);
  }

  getStudyProgramById(id: number) {
    return this.http.get(`${this.uri}/${id}`)
  }

  getAllCenters(): Observable<Center[]>{
    return this.http.get<any[]>(this.Center_URL);
  }

  pushFileToStorage(file: File, name: string, selectedCenterId: number ): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
 
    formdata.append('file', file);
    formdata.append('name', name);
    formdata.append('center', selectedCenterId.toString());
 
    const req = new HttpRequest('POST', 'http://localhost:8080/studyprogram/file/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });
 
    return this.http.request(req);
  }
}