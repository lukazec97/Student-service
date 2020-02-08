import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { CenterService } from '../center.service';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-center',
  templateUrl: './create-center.component.html',
  styleUrls: ['./create-center.component.css']
})
export class CreateCenterComponent implements OnInit {

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  name: string;
  angForm: any;

  constructor(private cs: CenterService, private fb: FormBuilder, private router: Router) {
    this.createForm();
  }

  ngOnInit() {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required]
    });
  }

  upload(name: string) {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.cs.pushFileToStorage(this.currentFileUpload, name).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.router.navigateByUrl('/', { skipLocationChange: false }).then(() => {
          window.location.reload();
        });
      }
    });
    this.selectedFiles = undefined;
  }
}