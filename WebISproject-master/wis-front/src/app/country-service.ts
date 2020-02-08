import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
  })
  export class CountryService {
  
    uri = 'http://localhost:8080/country';
    reloadData: any;
  
    constructor(private http: HttpClient) { }



    getCountries() {
        return this
               .http
               .get(`${this.uri}`);
      }

      getCountryById(id) {
        return this
                .http
                .get(`${this.uri}/${id}`);
        }
    
  }
