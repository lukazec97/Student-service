import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TeacherService } from '../teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private ts: TeacherService, private router: Router) {
    this.createForm();
   }

  createForm() {
    this.angForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      personalIdentificationNumber: ['', Validators.required]
    });
  }
  ngOnInit() {
  }
   addTeacher(firstName, lastName, personalIdentificationNumber) {
    this.ts.addTeacher(firstName, lastName, personalIdentificationNumber);
    alert('You have succesfully registered a new Teacher');
    this.router.navigate(['teacher']);
  }

  refresh() {
    this.router.navigate(['teacher']);
    this.ngOnInit();
  }
}
