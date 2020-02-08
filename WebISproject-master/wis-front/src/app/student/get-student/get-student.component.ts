import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent implements OnInit {

  students: Student[];
  blob: Blob;

  selStudent: Student;

  constructor(private ss: StudentService, private router: Router) { }


  deleteStudent(id) {
    this.ss.deleteStudent(id).subscribe(res => {
      console.log('Deleted');
      this.router.navigate(['/user-dashboard/students']).then(() => window.location.reload());
      this.ngOnInit();
    });
  }

  downloadStudentXML(id)
  {

    this.students.forEach(element => {
      
      if(element.id == id)
        this.selStudent = element;

    });


    this.ss.getXML(id).subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/xml'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = this.selStudent.firstName + " " + this.selStudent.lastName + " " + this.selStudent.cardNumber + ".xml";
      link.click();
    
    });
    
  }
  downloadAllStudentsXML()
  {

    


    this.ss.getAllXML().subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/xml'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = "students.xml";
      link.click();
    
    });
    
  }

  downloadStudentPDF(id)
  {

    this.students.forEach(element => {
      
      if(element.id == id)
        this.selStudent = element;

    });


    this.ss.getPDF(id).subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/pdf'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = this.selStudent.firstName + " " + this.selStudent.lastName + " " + this.selStudent.cardNumber + ".pdf";
      link.click();
    
    });
    
  }

  downloadAllStudentsPDF()
  {
    this.ss.getAllPDF().subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/pdf'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;

      
      link.download = "students.pdf";
      link.click();
    
    });
    
  }

  ngOnInit() {
    this.ss
      .getStudents()
      .subscribe((data: Student[]) => {
        this.students = data;
    });
  }

  getFileNameFromHttpResponse(httpResponse):string {
    var contentDispositionHeader = httpResponse.headers.get('Content-Disposition');
    var result = contentDispositionHeader.split(';')[1].trim().split('=')[1];
  return result.replace(/"/g, '');
  }
}


