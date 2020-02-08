import { Component, OnInit } from '@angular/core';
import YearOfStudy from 'src/app/yearOfstudy/YearOfStudy';
import Course from '../Course';
import { CourseService } from '../course.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})
export class CreateCourseComponent implements OnInit {

  yearOfStudy: YearOfStudy[];
  angForm: any;
  course: Course = new Course();
  selectedYearOfStudyId: number = 1;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  constructor(private cs: CourseService, private router: Router,  private fb: FormBuilder) { }

  ngOnInit() {
    this.createForm();
    this.cs.getAllYearOfStudy().subscribe(
      data => {
        this.yearOfStudy = data.map(item =>{
            return{
              id: item.id,
              title: item.title,
              studyProgram: item.studyProgram,
              numberOfYear: item.numberOfYear
            };
        });
      });
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  setYearOfStudy($event){
    this.selectedYearOfStudyId = $event;
    console.log(this.selectedYearOfStudyId);
  }

  createForm() {
    this.angForm = this.fb.group({
      title: ['', Validators.required ]
    });
  }

  upload(title: string) {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.cs.pushFileToStorage(this.currentFileUpload, title, this.selectedYearOfStudyId).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });
    this.selectedFiles = undefined;
    setTimeout(() => {
      this.router.navigateByUrl('/', { skipLocationChange: false }).then(() => {
        window.location.reload();
      });
    }, 2000);
  }

}
