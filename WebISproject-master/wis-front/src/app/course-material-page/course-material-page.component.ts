import { Component, OnInit } from '@angular/core';
import { StudyProgramService } from '../studyPrograms/study-program.service';
import { CenterService } from '../centers/center.service';
import { Router } from '@angular/router';
import { CourseService } from '../courses/course.service';
import Course from '../courses/Course';
import { DomSanitizer } from '@angular/platform-browser';
import { ObavestenjaService } from '../obavestenja.service';

@Component({
  selector: 'app-course-material-page',
  templateUrl: './course-material-page.component.html',
  styleUrls: ['./course-material-page.component.css']
})
export class CourseMaterialPageComponent implements OnInit {
  
  title: string;
  pic: Int8Array = new Int8Array();
  mimetype: string;
  sadrzajObavestenja: string;
  datumObavestenja: string;
  temaObavestenja: string;
  svaObavestenja = [];
  prikazi: boolean = false;
  
  role: string;

  constructor(private os: ObavestenjaService ,private sanitizer: DomSanitizer, private courseS: CourseService, private router: Router) { }

  ngOnInit() {
    this.courseS.getCourseById(Number(localStorage.getItem('idCourse'))).subscribe((data: Course) => {
      this.title = data.title;
      this.pic = data.pic;
      this.mimetype = data.mimetype;
    });
    this.role = localStorage.getItem("role");

  }

  transform(img: Int8Array, mimetype: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:' + mimetype + ';base64, ' + img.toString());
  }

  ubaciObavestenja(): void {
    this.os.listaObavestenja = JSON.parse(localStorage.getItem("obavestenja") || "[]");
    let o = {"tema": this.temaObavestenja, "datum": this.datumObavestenja, "sadrzaj": this.sadrzajObavestenja, "usernameProf": localStorage.getItem("username"), "predmet": this.title};
    this.os.listaObavestenja.push(o);
    localStorage.setItem("obavestenja", JSON.stringify(this.os.listaObavestenja));

  }

  dobaviObavestenja(): void {
    this.prikazi = true;
    let ob = JSON.parse(localStorage.getItem("obavestenja") || "[]");
    this.os.listaObavestenja = ob;
    console.log(ob);
    this.svaObavestenja = ob;
  }

  zatvoriObavestenja(): void {
    this.prikazi = false;
  }
 }
