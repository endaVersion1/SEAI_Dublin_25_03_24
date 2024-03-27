import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'name-list-app';
  names: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('assets/mock-data.json').subscribe((data: any) => {
      this.names = data;
    });
  }
}
