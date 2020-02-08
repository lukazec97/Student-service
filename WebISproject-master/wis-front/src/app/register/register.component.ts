import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  angFormStudent: FormGroup;
  angFormTeacher: FormGroup;
  angFormAdmin: FormGroup;

  role: string;
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  cardnumber: string;
  personalid: string;

  showAdminFields:boolean = false;
  showStudentFields:boolean = false;
  showTeacherFields:boolean = false;


  constructor(private fb: FormBuilder, private rs: RegistrationService, private router: Router) { 
    this.createFormAdmin();
    
    this.createFormStudent();
    
    this.createFormTeacher();
  }

  ngOnInit() {
  }

  createFormStudent() {
    this.angFormStudent = this.fb.group({
      username: ['', Validators.required ],
      pass: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      cardnumber: ['', Validators.required]
    });
  }

  createFormTeacher() {
    this.angFormTeacher = this.fb.group({
      username: ['', Validators.required ],
      pass: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      personalid: ['', Validators.required]
    });
  }

  createFormAdmin() {
    this.angFormAdmin = this.fb.group({
      username: ['', Validators.required ],
      pass: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required]
    });
  }



  setStudentRole() {
    this.showStudentFields = true;
    this.showTeacherFields = false;
    this.showAdminFields = false;
    this.role = "ROLE_STUDENT";
  }

  setTeacherRole() {
    this.showTeacherFields = true;
    this.showAdminFields = false;
    this.showStudentFields = false;
    this.role = "ROLE_TEACHER";
  }

  setAdminRole() {
    this.showAdminFields = true;
    this.showTeacherFields = false;
    this.showStudentFields = false;
    this.role = "ROLE_ADMIN";
  }

  register(username: string, password: string) {
    //this.rs.register(username, password, this.role);
    this.router.navigate(['/']);
  }

  registerStudent(username: string, password: string, firstname: string, lastname: string, cardnumber: string)
  {
    this.rs.registerStudent(username, password, this.role, firstname, lastname, cardnumber);
    console.log(this.firstname);
    alert('You have succesfully added a new Student');
    
    this.router.navigate(['/user-dashboard/students']).then(() => window.location.reload());

    
    
  }

  registerTeacher(username: string, password: string, firstname: string, lastname: string, personalid: string)
  {
    this.rs.registerTeacher(username, password, this.role, firstname, lastname, personalid);
    console.log(this.firstname);
    this.router.navigate(['/user-dashboard/teacher']).then(() => window.location.reload());

  }

  registerAdmin(username: string, password: string, firstname: string, lastname: string)
  {
    this.rs.registerAdmin(username, password, this.role, firstname, lastname);
    console.log(this.firstname);
  }

}
