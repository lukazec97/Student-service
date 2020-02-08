import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { StudentService } from '../student.service';
@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

  student: any = {};
  angForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private ss: StudentService,
              private fb: FormBuilder) {
      this.createForm();
 }

  createForm() {
    this.angForm = this.fb.group({
        firstName: ['', Validators.required ],
        lastName: ['', Validators.required ],
        cardNumber: ['', Validators.required ]
      });
    }

  updateStudent(firstName, lastName, cardNumber) {
    this.route.params.subscribe(params => {
      this.ss.updateStudent(firstName, lastName, cardNumber, params.id);
      alert('You have succesfully changed a Student');
      this.router.navigate(['/user-dashboard/students']).then(() => window.location.reload());

        
      
 });
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
        this.ss.editStudent(params.id).subscribe(res => {
          this.student = res;
      });
    });
  }
}
