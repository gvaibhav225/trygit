import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BookmarkedJob } from 'src/app/api/Bookmarkjob.model';
import { JobApplication } from 'src/app/api/JobApplication.model';

@Component({
  selector: 'app-bookmark',
  templateUrl: './bookmark.component.html',
  styleUrls: ['./bookmark.component.css']
})
export class BookmarkComponent implements OnInit {

  allactivejobs:any
  allbookmarkjobbyfree:any
  allappliedjobbyfree:any
  bookmarkedJob: BookmarkedJob=new BookmarkedJob
  jobApplication: JobApplication=new JobApplication
  constructor(private _http:HttpClient) { }

  ngOnInit(): void {
this.getallactivejobs(),
this.getallbookmarkedjob(),
this.getallappliedjobsbyfree()
  }

getallactivejobs(){
  this._http.get<any>("http://localhost:8080/jobfindbyactive").subscribe(res=>{
this.allactivejobs=res

  })
}
httpOptions={
  headers:new HttpHeaders({'Content-Type':'application/json'})
}
reqid =  localStorage.getItem('freelancerid')

getallbookmarkedjob(){
  this._http.get<any>("http://localhost:8080/bookmarkjobfindbyfree/"+JSON.parse(this.reqid!), this.httpOptions).subscribe(res=>{
this.allbookmarkjobbyfree=res
  })
}

bookmarkjob(data:any){
this.bookmarkedJob.freelancerId=JSON.parse(this.reqid!)
this.bookmarkedJob.jobId=data.id

this._http.post<any>("http://localhost:8080/bookmarkedjobadd", this.bookmarkedJob, this.httpOptions).subscribe(res=>{
  alert("Bookmarked Successsfully")

  this.getallbookmarkedjob()
})

}



getallappliedjobsbyfree(){
  this._http.get<any>("http://localhost:8080/jobappfindbyfree/"+JSON.parse(this.reqid!), this.httpOptions).subscribe(res=>{
    
this.allappliedjobbyfree=res
  })

}



Apply(data:any){
  this.jobApplication.coverLetter=" "
  this.jobApplication.freelancerid=JSON.parse(this.reqid!)
  this.jobApplication.jobid=data.id

  this._http.post<any>("http://localhost:8080/jobappsave", this.jobApplication, this.httpOptions).subscribe(res=>{
    alert("job applied successfully")
    this.getallappliedjobsbyfree()

  })


}

deletebookmarkjob(data:any){
  this._http.delete<any>("http://localhost:8080/bookmarkjobdelete/"+data.id, this.httpOptions).subscribe(res=>{
    alert("Deleated Successfully")
    this.getallbookmarkedjob()
  })
}


 
}
