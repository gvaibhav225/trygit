import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/api/Admin.model';
import { SharedService } from 'src/app/api/shared.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginform!:FormGroup
rolee:string | undefined
  

  constructor( private formbuilder:FormBuilder,private api:SharedService, private _http:HttpClient, private router: Router) { }

 

  ngOnInit(): void {
    this.loginform=this.formbuilder.group({
      firstname:['',Validators.required],
      password:['', Validators.required],
      role:['', Validators.required]

    })



  }
  login(){

    this.rolee=this.loginform.value.role

    if(this.rolee==='1'){
      this._http.get<any>("http://localhost:8080/adminFindAll").subscribe(res=>{
        console.log(res)
        const ans=res.find((a:any)=>{
          localStorage.setItem('adminid',a.id)
          return a.firstName===this.loginform.value.firstname && a.password===this.loginform.value.password
        })
        if(ans){
          this.loginform.reset()

          this.router.navigate(['admin'])
          
  
        }else{
          this.loginform.reset()
          alert("User Not Found")
        }
      }
      
      
      )
    }else if(this.rolee==='2'){
      this._http.get<any>("http://localhost:8080/recruiterFindAll").subscribe(res=>{
        console.log(res)
        const ans=res.find((a:any)=>{
          localStorage.setItem('recruiterid', JSON.stringify( a.id))
          return a.firstName===this.loginform.value.firstname && a.password===this.loginform.value.password
        })
        if(ans){
          this.loginform.reset()
          this.router.navigate(['recruiter'])
  
        }else{
          this.loginform.reset()
          alert("User Not Found")
        }
      }
      
      
      )
    }else if(this.rolee==='3'){
      this._http.get<any>("http://localhost:8080/freeFindAll").subscribe(res=>{
        console.log(res)
        const ans=res.find((a:any)=>{
          localStorage.setItem('freelancerid',a.id)
          return a.firstName===this.loginform.value.firstname && a.password===this.loginform.value.password
        })
        if(ans){
          this.loginform.reset()
          this.router.navigate(['freelancer'])
  
        }else{
          this.loginform.reset()
          alert("User Not Found")
        }
      }
      
      
      )
    }


  }



}
