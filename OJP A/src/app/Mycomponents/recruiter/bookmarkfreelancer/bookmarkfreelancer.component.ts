import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bookmarkfreelancer',
  templateUrl: './bookmarkfreelancer.component.html',
  styleUrls: ['./bookmarkfreelancer.component.css']
})
export class BookmarkfreelancerComponent implements OnInit {


  allfreelist:any

  constructor( private _http:HttpClient) { }

  ngOnInit(): void {
    this.getallfree()
  }

  getallfree(){
    
    this._http.get<any>("http://localhost:8080/freeFindAll").subscribe(res=>{
      this.allfreelist=res
  })
  }

  bookmark(data:any){

  }

}
