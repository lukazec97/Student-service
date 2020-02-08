import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import StudyProgram from 'src/app/studyPrograms/StudyProgram';
import { StudentService } from '../student.service';
import { StudyProgramService } from 'src/app/studyPrograms/study-program.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enroll-next',
  templateUrl: './enroll-next.component.html',
  styleUrls: ['./enroll-next.component.css']
})
export class EnrollNextComponent implements OnInit {
  student: Student[];
  selectedStudent: Student;
  selectedStudentId: number = 0;



  constructor(private ss: StudentService, private router: Router) { }

  ngOnInit() {
    this.ss
    .getStudents()
    .subscribe((data: Student[]) => {
      this.student = data;
  });

    
    
  }


  setStudent($event){
    this.selectedStudentId = $event;
    console.log(this.selectedStudentId);
  }




  

  enrollStudent() {
    
    if(this.selectedStudentId == 0)
      this.selectedStudentId = this.student[0].id;
    
    
    this.ss.enrollStudentNext(this.selectedStudentId);

    
   
  }

  
}


