import { Component, OnInit } from '@angular/core';
import Center from '../../centers/Center';
import StudyProgram from '../StudyProgram';
import { StudyProgramService } from '../study-program.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-sp',
  templateUrl: './create-sp.component.html',
  styleUrls: ['./create-sp.component.css']
})
export class CreateSpComponent implements OnInit {

  center: Center[];
  studyProgram: StudyProgram = new StudyProgram();
  angForm: any;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  selectedCenterId: number = 1;
  constructor(private sps: StudyProgramService, private router: Router,  private fb: FormBuilder) { }

  ngOnInit() {
    this.createForm();
    this.sps.getAllCenters().subscribe(
      data => {
        this.center = data.map(item =>{
            return{
              id: item.id,
              name: item.name,
              studyPrograms: item.studyPrograms,
              pic: item.pic,
              mimetype: item.mimetype
            };
        });
      });
}

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  setCenter($event){
    this.selectedCenterId = $event;
    console.log(this.selectedCenterId);
  }

  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required ]
    });
  }

  upload(name: string) {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.sps.pushFileToStorage(this.currentFileUpload, name, this.selectedCenterId).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.router.navigateByUrl('/', { skipLocationChange: false }).then(() => {
          window.location.reload();
        });
      }
    });
  }

}
