import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import Student from '../Student';
import StudyProgram from 'src/app/studyPrograms/StudyProgram';
import { StudyProgramService } from 'src/app/studyPrograms/study-program.service';

@Component({
  selector: 'app-enroll-student',
  templateUrl: './enroll-student.component.html',
  styleUrls: ['./enroll-student.component.css']
})
export class EnrollStudentComponent implements OnInit {

  student: Student[];
  selectedStudent: Student;
  selectedStudentId: number = 0;

  studyProgram: StudyProgram[];
  selectedStudyProgram: StudyProgram;
  selectedStudyProgramId: number = 0;


  constructor(private ss: StudentService, private sps: StudyProgramService, private router: Router) { }

  ngOnInit() {
    this.ss
    .getStudents()
    .subscribe((data: Student[]) => {
      this.student = data;
  });

    this.sps
    .getStudyProgram()
    .subscribe((data: StudyProgram[]) => {
      this.studyProgram = data;
  });
    
  }


  setStudent($event){
    this.selectedStudentId = $event;
    console.log(this.selectedStudentId);
  }

  setStudyProgram($event){
    this.selectedStudyProgramId = $event;
    console.log(this.selectedStudyProgramId);
  }


  

  enrollStudent() {
    
    if(this.selectedStudentId == 0)
      this.selectedStudentId = this.student[0].id;
    
    if(this.selectedStudyProgramId == 0)
      this.selectedStudyProgramId = this.studyProgram[0].id;

    this.ss.enrollStudent(this.selectedStudentId, this.selectedStudyProgramId);

    
   
  }

  

}
