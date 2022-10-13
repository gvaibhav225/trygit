import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminrecruiter',
  templateUrl: './adminrecruiter.component.html',
  styleUrls: ['./adminrecruiter.component.css']
})
export class AdminrecruiterComponent implements OnInit {

  allfreelist:any
  constructor(private _http:HttpClient) { }

  ngOnInit(): void {
    this.getallrecruiter()
  }

  getallrecruiter(){
    this._http.get<any>("http://localhost:8080/recruiterFindAll").subscribe(res=>{
      this.allfreelist=res
  })
  }
}
