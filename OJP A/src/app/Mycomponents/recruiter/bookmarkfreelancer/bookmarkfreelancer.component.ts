import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Bookmarkfreelancer } from 'src/app/api/BookmarkedFreelancer.model';

@Component({
  selector: 'app-bookmarkfreelancer',
  templateUrl: './bookmarkfreelancer.component.html',
  styleUrls: ['./bookmarkfreelancer.component.css']
})
export class BookmarkfreelancerComponent implements OnInit {

  bookmarkfreelancer: Bookmarkfreelancer=new Bookmarkfreelancer
  allfreelist:any
  allbookfreelist:any
  done!:boolean
  
  constructor( private _http:HttpClient) { }

  ngOnInit(): void {
    this.getallfree()
    this.getallbookmarkfree()
  }
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }

  getallfree(){
    
    this._http.get<any>("http://localhost:8080/freeFindAll").subscribe(res=>{
      this.allfreelist=res
  })
  }

  

  getallbookmarkfree(){
    
    this._http.get<any>("http://localhost:8080/bookmarkfreefinall").subscribe(res=>{
      this.allbookfreelist=res
  })
  }

  reqid =  localStorage.getItem('recruiterid')


  bookmark(data:any){

    this.bookmarkfreelancer.freelanceId=data.id
     this.bookmarkfreelancer.recruiterId =  JSON.parse(this.reqid!)


    this._http.post<any>("http://localhost:8080/bookmarkedFreelancersave", this.bookmarkfreelancer , this.httpOptions).subscribe(res=>{
      alert("bookmarked")
 
      this.getallbookmarkfree()
    })

  }

  deletebookmark(data:any){
this._http.delete<any>("http://localhost:8080/bookmarkfreedlt/"+data.id, this.httpOptions).subscribe(res=>{

alert("bookmark removed")
this.getallbookmarkfree();
})

  }

}
