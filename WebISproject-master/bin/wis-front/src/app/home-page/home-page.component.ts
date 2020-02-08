import { Component, OnInit, OnDestroy } from '@angular/core';
import Center from '../centers/Center';
import { CenterService } from '../centers/center.service';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  centers: Center[];
  constructor(private dataService: DataService,private router: Router, private sanitizer:DomSanitizer, private cnt: CenterService) {
 
   }

  ngOnInit() {
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;
    });

    if(localStorage.getItem("username") === null)
      localStorage.setItem("username", "Guest");

    console.log(localStorage.getItem("username"));
  }

  punjenje(id): void {
    this.dataService.idCenter = id;
    localStorage.setItem("idCentra", this.dataService.idCenter.toString());
  }

  transform(img:Int8Array, mimetype:string){
    return this.sanitizer.bypassSecurityTrustResourceUrl("data:" + mimetype + ";base64, " + img.toString());
}

  ngOnDestroy() {
    
  }

  
}
