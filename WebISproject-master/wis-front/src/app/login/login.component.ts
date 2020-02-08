import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StudentService } from '../student/student.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  teacherRole: boolean = false;
  studentRole: boolean = false;
  adminRole: boolean = false;
  role: string;

  angForm: FormGroup;
  location: any;
  constructor(private fb: FormBuilder, private ss: StudentService, private router: Router, private ls: LoginService) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      username: ['', Validators.required],
      pass: ['', Validators.required]
    });
  }

  login(username: string, password: string) {
    this.ls.login(username, password);

    setTimeout(() => {
      this.router.navigateByUrl('/user-dashboard', { skipLocationChange: false }).then(() => {
        localStorage.setItem('username', username);
        window.location.reload();

      });
    }, 2000);
  }
  ngOnInit() {
  }

  test() {
    this.ls.test();
  }

  redirectTo(uri) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }

}
