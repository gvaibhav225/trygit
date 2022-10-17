import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SkillExperience } from 'src/app/api/SkillExperience.model';

@Component({
  selector: 'app-skillexp',
  templateUrl: './skillexp.component.html',
  styleUrls: ['./skillexp.component.css']
})
export class SkillexpComponent implements OnInit {
  allskilldata:any
  allskillexbyfree:any
  formValue!:FormGroup
  formValue1!:FormGroup
  reqq:any
  constructor(private _http:HttpClient, private formbuilder:FormBuilder) { }
  skillExperience: SkillExperience=new SkillExperience
  ngOnInit(): void {
    this.formValue=this.formbuilder.group({
      years:[''],
      skillname:['']
    })
    this.formValue1=this.formbuilder.group({
      years1:['']
    })

    this.getallskills()
    this.getskillexbyfree()
  }
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }
  reqid =  localStorage.getItem('freelancerid')
  getallskills(){
    this._http.get<any>("http://localhost:8080/skillFindAll").subscribe(res=>{
    
    this.allskilldata=res
    
    })
    }

addskillex(){
  this.skillExperience.freelancerid=JSON.parse(this.reqid!)
  this.skillExperience.skillname=this.formValue.value.skillname
  this.skillExperience.years=this.formValue.value.years

  this._http.post<any>("http://localhost:8080/skillexsave",this.skillExperience,this.httpOptions).subscribe(res=>{
    alert("skill experience added successfully")
    this.formValue.reset()
    this.getskillexbyfree()
  })


}

getskillexbyfree(){

  this._http.get<any>("http://localhost:8080/skillexfindall/"+JSON.parse(this.reqid!),this.httpOptions).subscribe(res=>{

  this.allskillexbyfree=res
  })
}

value(data:any){
this.reqq=data.id
}

update(){
this.skillExperience.years=this.formValue1.value.years1

this._http.put<any>("http://localhost:8080/skillexupdate/"+ this.reqq, this.skillExperience, this.httpOptions).subscribe(res=>{
alert("updated successfully")
this.getskillexbyfree()
this.formValue1.reset()
})

}



}
