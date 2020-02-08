import { Component, OnInit, OnDestroy } from '@angular/core';
import Center from '../centers/Center';
import { CenterService } from '../centers/center.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { DomSanitizer } from '@angular/platform-browser';
import Country from '../Country';
import { CountryService } from '../country-service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  centers: Center[];
  country: Country[];

  countries:  any={};
  constructor(private route: ActivatedRoute,private dataService: DataService,private router: Router, private sanitizer:DomSanitizer, private cnt: CenterService ,private cos: CountryService) {
 
   }

  ngOnInit() {
    this.cnt.getCenter()
    .subscribe((data: Center[]) => {
      this.centers = data;

    });
    this.route.params.subscribe(params => {
      this.cos.getCountryById(params.id).subscribe(res => {
        this.countries = res;
    });
  });

    if(localStorage.getItem("username") === null)
      localStorage.setItem("username", "Guest");

    console.log(localStorage.getItem("username"));

    this.cos
    .getCountries()
    .subscribe((data: Country[]) => {
      this.country = data;
});
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
