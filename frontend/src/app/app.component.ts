import { Component, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private http: HttpClient) { }
  
  title = 'frontend';

  candidate = 'Érico Nascimento Bornéo';

  companies =[]

  configUrl = 'http://localhost:8080/company';

  getCompanies() {
    this.http.get(this.configUrl,{responseType: 'json'}).subscribe((resp:any) => {
      this.companies = resp;
    })
    
  }
}
