import { Component, OnInit } from '@angular/core';
import Center from '../centers/Center';
import { DataService } from '../data.service';
import { StudyProgramService } from '../studyPrograms/study-program.service';
import { CenterService } from '../centers/center.service';
import { Router } from '@angular/router';
import StudyProgram from '../studyPrograms/StudyProgram';

@Component({
  selector: 'app-course-material-page',
  templateUrl: './course-material-page.component.html',
  styleUrls: ['./course-material-page.component.css']
})
export class CourseMaterialPageComponent implements OnInit {

  center: Center[];
  studyProgram: StudyProgram[];

  constructor(private dataService: DataService, private sps: StudyProgramService, private cs: CenterService, private router: Router) { }

  ngOnInit() {
    this.cs.getCenter()
    .subscribe((data: Center[]) => {
      this.center = data;
    });

    this.sps.getStudyProgram()
    .subscribe((data: StudyProgram[]) => {
      this.studyProgram = data;
    });

  }

}
