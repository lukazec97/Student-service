import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import StudyProgram from '../studyPrograms/StudyProgram';
import YearOfStudy from '../yearOfstudy/YearOfStudy';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  uri = 'http://localhost:8080/course';
  private yosUrl = "http://localhost:8080\\yearofstudy";
  reloadData: any;

  constructor(private http: HttpClient) { }

  getCourse() {
      return this
          .http
          .get(`${this.uri}`);
  }

  getCourseByTitle(title: string): Observable<any> {
      return this.http.get(`${this.uri}/title/${title}`);
  }

  getCourseById(id: number) {
      return this.http.get(`${this.uri}/${id}`)
  }

  getAllYearOfStudy(): Observable<YearOfStudy[]> {
      return this.http.get<any[]>(this.yosUrl);
  }

  pushFileToStorage(file: File, title: string, selectedYearOfStudyId: number): Observable<HttpEvent<{}>> {
      const formdata: FormData = new FormData();

      formdata.append('file', file);
      formdata.append('title', title);
      formdata.append('yearOfStudy', selectedYearOfStudyId.toString());

      const req = new HttpRequest('POST', 'http://localhost:8080/course/file/upload', formdata, {
          reportProgress: true,
          responseType: 'text'
      });
      return this.http.request(req);
  }
}
