import { Component, OnInit } from '@angular/core';
import Teacher from '../Teacher';
import { TeacherService } from '../teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-teacher',
  templateUrl: './get-teacher.component.html',
  styleUrls: ['./get-teacher.component.css']
})
export class GetTeacherComponent implements OnInit {

  teachers: Teacher[];
  blob: Blob;
  selTeacher: Teacher;

  constructor(private ts: TeacherService, private router: Router) { }

deleteTeacher(id: number) {
  this.ts.deleteTeacher(id).subscribe(res => {
    console.log('Deleted');
    this.router.navigate(['/user-dashboard/teacher']).then(() => window.location.reload());
    this.ngOnInit();
  });
}

ngOnInit() {
  this.ts
    .getTeachers()
    .subscribe((data: Teacher[]) => {
      this.teachers = data;
});

}

downloadTeacherXML(id)
  {

    this.teachers.forEach(element => {
      
      if(element.id == id)
        this.selTeacher = element;

    });


    this.ts.getXML(id).subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/xml'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = this.selTeacher.firstName + " " + this.selTeacher.lastName + " " + this.selTeacher.personalIdentificationNumber + ".xml";
      link.click();
    
    });
    
  }

  downloadAllTeachersXML()
  {

    


    this.ts.getAllXML().subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/xml'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = "teachers.xml";
      link.click();
    
    });
    
  }

downloadTeacherPDF(id)
  {

    this.teachers.forEach(element => {
      
      if(element.id == id)
        this.selTeacher = element;

    });


    this.ts.getPDF(id).subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/pdf'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = this.selTeacher.firstName + " " + this.selTeacher.lastName + " " + this.selTeacher.personalIdentificationNumber + ".pdf";
      link.click();
    
    });
    
  }

  downloadAllTeachersPDF()
  {
    this.ts.getAllPDF().subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/pdf'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = "teachers.pdf";
      link.click();
    
    });
    
  }

}
