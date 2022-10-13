import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminfreelancer',
  templateUrl: './adminfreelancer.component.html',
  styleUrls: ['./adminfreelancer.component.css']
})
export class AdminfreelancerComponent implements OnInit {


  allfreelist: any
  constructor( private _http:HttpClient) { }

  ngOnInit(): void {
    this.getallfree()
  }
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }
  getallfree(){
    
    this._http.get<any>("http://localhost:8080/freeFindAll").subscribe(res=>{
      this.allfreelist=res
  })
  }

  delete(data:any){
    this._http.delete<any>("http://localhost:8080/deletefree/"+data.id ,this.httpOptions  ).subscribe(res=>{
      alert('Deleated Successfully')
      this.getallfree()
    })
  }
  


}
