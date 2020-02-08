import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-search-student',
  templateUrl: './search-student.component.html',
  styleUrls: ['./search-student.component.css']
})
export class SearchStudentComponent implements OnInit {

  firstName: string;
  lastName: string;
  students: Student[];

  constructor(private ss: StudentService) { }

  ngOnInit() {
    this.firstName = '';
    this.lastName = '';
  }

  private searchStudentsFirst() {
    this.ss.getStudentByFirstName(this.firstName)
      .subscribe(students => this.students = students);
      }

  private searchStudentsLast() {
    this.ss.getStudentByLastName(this.lastName)
      .subscribe(students => this.students = students);
      }

  private searchStudents() {
    this.ss.searchStudent(this.firstName)
      .subscribe(students => this.students = students);
        }

  searchSubmit()
  {
    this.searchStudents();
  }

  onSubmitFirst() {
    this.searchStudentsFirst();
  }

  onSubmitLast() {
    this.searchStudentsLast();
  }

}
