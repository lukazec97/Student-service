import { Component, OnInit } from '@angular/core';
import Teacher from '../Teacher';
import {TeacherService} from '../teacher.service';

@Component({
  selector: 'app-search-teacher',
  templateUrl: './search-teacher.component.html',
  styleUrls: ['./search-teacher.component.css']
})
export class SearchTeacherComponent implements OnInit {

  firstName: string;
  teachers: Teacher[];

  constructor(private ts: TeacherService) { }

  ngOnInit() {
    this.firstName = '';
  }

  private searchTeachersFirst() {
    this.ts.getTeacherByFirstName(this.firstName)
      .subscribe(teachers => this.teachers = teachers);
      }

  onSubmit() {
    this.searchTeachersFirst();
  }

}
