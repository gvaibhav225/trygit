import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  message: any;

  constructor( private _http:HttpClient) { }
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }
  postAdmin(data:any){
    return this._http.post<any>("http://localhost:8080/adminSave",data, this.httpOptions).pipe(map((res:any)=>{
      return res;
    }))
  }
  setmessage(data: any){
    this.message=data
  }
  getmessage(){
    return this.message
  }


}
