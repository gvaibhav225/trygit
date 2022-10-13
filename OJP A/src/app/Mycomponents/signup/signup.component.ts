import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/api/Admin.model';
import { Freelancer } from 'src/app/api/Freelancer.model';
import { Recruiter } from 'src/app/api/Recruiter.model';
import { SharedService } from 'src/app/api/shared.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupform!:FormGroup
  admin: Admin=new Admin
  freelancer: Freelancer=new Freelancer
  recruiter: Recruiter=new Recruiter
  rolee:string | undefined
  ans:any
  constructor(private formbuilder: FormBuilder,  private api:SharedService, private _http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.signupform=this.formbuilder.group({
      firstname:['', Validators.required],
      lastname:['',Validators.required],
      password:['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$")]],
      role:['',Validators.required]
    })
  }

  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }
  
signup(){
  this.rolee=this.signupform.value.role
this.admin.firstname=this.signupform.value.firstname
this.admin.lastname=this.signupform.value.lastname
this.admin.password=this.signupform.value.password


console.log(this.admin)


if(this.rolee==='1'){

  

  this._http.get<any>("http://localhost:8080/adminFindAll").subscribe(res=>{
    const ans=res.find((a:any)=>{
          return a.firstName===this.signupform.value.firstname
        })
        if(ans){
          this.signupform.reset()
          alert("username exists, kindly choose another username")
        }
        else{
  

          this.admin.firstname=this.signupform.value.firstname
        this.admin.lastname=this.signupform.value.lastname
        this.admin.password=this.signupform.value.password
        
        
        console.log(this.admin)
        
          this._http.post<any>("http://localhost:8080/adminSave",this.admin,this.httpOptions).subscribe(res=>{
            // console.log(JSON.parse(res))
         
            alert("signup successfully")
            this.signupform.reset()
            //now for redirecting we use router in constructor
            this.router.navigate(['login'])
          },
          err=>{
            // console.log(res)
            console.log(err)
            this.signupform.reset()
            alert("something went wrong")
        
          }
          )
        }
      
      })

     
}else if(this.rolee==='2'){

  
  this._http.get<any>("http://localhost:8080/recruiterFindAll").subscribe(res=>{
    const ans=res.find((a:any)=>{
          return a.firstName===this.signupform.value.firstname
        })
        if(ans){
          this.signupform.reset()
          alert("username exists, kindly choose another username")
        }
        else{
  


          this.recruiter.firstName=this.signupform.value.firstname
          this.recruiter.lastName=this.signupform.value.lastname
          this.recruiter.password=this.signupform.value.password
          
          
          console.log(this.recruiter)
          
          
            this._http.post<any>("http://localhost:8080/recruitersave",this.recruiter,this.httpOptions).subscribe(res=>{
              // console.log(JSON.parse(res))
           
              alert("signup successfully")
              this.signupform.reset()
              //now for redirecting we use router in constructor
              this.router.navigate(['login'])
            },
            err=>{
              // console.log(res)
              console.log(err)
              this.signupform.reset()
              alert("something went wrong")
          
            }
            )
        }
      
      })
  


  
} else if(this.rolee==='3'){

  
  this._http.get<any>("http://localhost:8080/freeFindAll").subscribe(res=>{
    const ans=res.find((a:any)=>{
          return a.firstName===this.signupform.value.firstname
        })
        if(ans){
          this.signupform.reset()
          alert("username exists, kindly choose another username")
        }
        else{

          this.freelancer.firstName=this.signupform.value.firstname
          this.freelancer.lastName=this.signupform.value.lastname
          this.freelancer.password=this.signupform.value.password
          
          
          console.log(this.freelancer)
          
          
            this._http.post<any>("http://localhost:8080/freesave",this.freelancer,this.httpOptions).subscribe(res=>{
              // console.log(JSON.parse(res))
           
              alert("signup successfully")
              this.signupform.reset()
              //now for redirecting we use router in constructor
              this.router.navigate(['login'])
            },
            err=>{
              // console.log(res)
              console.log(err)
              this.signupform.reset()
              alert("something went wrong")
          
            }
            )
        }
      
      })
  



}
 

}
}
