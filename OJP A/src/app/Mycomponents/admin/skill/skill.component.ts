import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Skill } from 'src/app/api/Skill.model';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  allskilllist:any
  formValue!:FormGroup
  skill: Skill=new Skill
 
  constructor(private formBuilder:FormBuilder,private _http:HttpClient) { }

  ngOnInit(): void {
    this.formValue=this.formBuilder.group({
      name:[''],
      desc:['']
    })
    this.getallskilllist()
  }

getallskilllist(){
  this._http.get<any>("http://localhost:8080/skillFindAll").subscribe(res=>{
    this.allskilllist=res
})
}

displayStyle = "none";
  
  openPopup() {
    this.formValue.reset()
    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }
  addSkill(){
    this.skill.name=this.formValue.value.name
    this.skill.description=this.formValue.value.desc

    this._http.post<any>("http://localhost:8080/skillsave", this.skill, this.httpOptions ).subscribe(res=>{
      alert("Skill added successfully")

      //form value does not get reseted after submission so
      this.formValue.reset()
  
  this.displayStyle="none"

  this.getallskilllist()

    })



  }
 
  delete(data:any){
    this._http.delete<any>("http://localhost:8080/delete/"+data.id ,this.httpOptions  ).subscribe(res=>{
      alert('Deleated Successfully')
      this.getallskilllist()
    })
  }


}
