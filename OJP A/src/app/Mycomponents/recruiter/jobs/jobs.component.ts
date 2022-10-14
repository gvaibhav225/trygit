import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Job } from 'src/app/api/Job.model';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {


  allskilldata:any
  job: Job=new Job
  getalljobbyrec:any
  formValue!:FormGroup
  constructor(private _http:HttpClient,private formbuilder:FormBuilder) { }

  ngOnInit(): void {
this.formValue=this.formbuilder.group({
title:[''],
desc:[''],
skill:['']
})
this.getjobbyrec()

    this.getallskills()
  }

getallskills(){
this._http.get<any>("http://localhost:8080/skillFindAll").subscribe(res=>{

this.allskilldata=res

})
}
httpOptions={
  headers:new HttpHeaders({'Content-Type':'application/json'})
}
reqid =  localStorage.getItem('recruiterid')
createjob(){
this.job.description=this.formValue.value.desc
this.job.recruiterid=JSON.parse(this.reqid!)
this.job.title=this.formValue.value.title
this.job.skillid=this.formValue.value.skill

this._http.post<any>("http://localhost:8080/jobsave", this.job, this.httpOptions).subscribe(res=>{
  alert("job added successfully")
  this.formValue.reset()
  this.getjobbyrec()


}, err=>{
  this.formValue.reset()
alert("something went wrong")
}
)
}

getjobbyrec(){
this._http.get<any>("http://localhost:8080/jobfindbyrecruiter/"+JSON.parse(this.reqid!), this.httpOptions).subscribe(res=>{
  this.getalljobbyrec=res
})

}

close(data:any){
this._http.get<any>("http://localhost:8080/close/"+data.id, this.httpOptions).subscribe(res=>{
  alert("closed successfully")
})

}


}
