import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObavestenjaService } from '../obavestenja.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private os: ObavestenjaService) {

  }

  showAdminPanel: boolean = false;
  showTeacherPanel: boolean = false;
  showStudentPanel: boolean = false;
  showLogin: boolean = false;
  ngOnInit() {
    if (localStorage.getItem("role") == null)
      this.showLogin = true;
  }

  signOut() {
    localStorage.clear();
    location.reload(true);
    localStorage.setItem("obavestenja", JSON.stringify(this.os.listaObavestenja));
    this.router.navigate(['/'])
    .then(() => {
    window.location.reload();
  });

  }

  redirectTo(uri) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }
}
