import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  angForm: FormGroup;
  constructor(private fb: FormBuilder, private ss: StudentService, private router: Router) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      cardNumber: ['', Validators.required ],
      pass: ['', Validators.required]
    });
  }
  ngOnInit() {
  }

  addStudent(firstName, lastName, cardNumber, pass) {
    this.ss.addStudent(firstName, lastName, cardNumber, pass);
    alert('You have succesfully registered a new Student');
    this.router.navigate(['students']);
    this.refresh();
  }

  refresh() {
    this.router.navigate(['students']);
    this.ngOnInit();
  }


}
