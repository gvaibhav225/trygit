import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './Mycomponents/admin/admin.component';
import { FreelancerComponent } from './Mycomponents/freelancer/freelancer.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import { RecruiterComponent } from './MyComponents/recruiter/recruiter.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';

const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"admin", component:AdminComponent},
  {path:"freelancer", component:FreelancerComponent},
  {path:"recruiter", component: RecruiterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
