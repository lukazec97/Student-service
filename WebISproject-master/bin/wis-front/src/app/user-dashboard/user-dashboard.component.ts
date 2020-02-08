import { Component, OnInit } from '@angular/core';
import { AdminService } from './admin-service';
import { Router } from '@angular/router';
import Admin from './Admin';
import { TeacherService } from '../teachers/teacher.service';
import { StudentService } from '../student/student.service';
import Teacher from '../teachers/Teacher';
import Student from '../student/Student';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  username: string;
  firstname: string;
  lastname: string;
  note: string;
  role: string;

  constructor(private as: AdminService, private router: Router, private ts: TeacherService, private ss: StudentService) { }

  ngOnInit() {
    this.role = localStorage.getItem("role");
    if (this.role === "ROLE_ADMIN") {
      this.as
        .getAdmin()
        .subscribe((data: Admin[]) => {
          for (var i = 0; i < data.length; i++) {
            if (localStorage.getItem("username") == data[i].user.username) {
              //this.admin = data[i];
              this.username = data[i].user.username;
              this.firstname = data[i].firstName;
              this.lastname = data[i].lastName;
              this.note = data[i].note;
              return;
            }
          }
        });
    }
    else if (this.role === "ROLE_TEACHER") {
      this.ts.getTeachers().subscribe((data: Teacher[]) => {
        for (var i = 0; i < data.length; i++) {
          if (localStorage.getItem("username") == data[i].user.username) {
            this.username = data[i].user.username;
            this.firstname = data[i].firstName;
            this.lastname = data[i].lastName;
            return;
          }
        }
      });
    }
    else if (this.role === "ROLE_STUDENT") {
      this.ss.getStudents().subscribe((data: Student[]) => {
        for (var i = 0; i < data.length; i++) {
          if (localStorage.getItem("username") == data[i].user.username) {
            this.username = data[i].user.username;
            this.firstname = data[i].firstName;
            this.lastname = data[i].lastName;
            return;
          }
        }
      });
    } else {
      return;
    }

  }

}
