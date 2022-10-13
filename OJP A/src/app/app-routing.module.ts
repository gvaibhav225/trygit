import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './Mycomponents/admin/admin.component';
import { AdminfreelancerComponent } from './Mycomponents/admin/adminfreelancer/adminfreelancer.component';
import { AdminrecruiterComponent } from './Mycomponents/admin/adminrecruiter/adminrecruiter.component';
import { SkillComponent } from './Mycomponents/admin/skill/skill.component';
import { BookmarkComponent } from './Mycomponents/freelancer/bookmark/bookmark.component';
import { FreelancerComponent } from './Mycomponents/freelancer/freelancer.component';
import { SkillexpComponent } from './Mycomponents/freelancer/skillexp/skillexp.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import { BookmarkfreelancerComponent } from './Mycomponents/recruiter/bookmarkfreelancer/bookmarkfreelancer.component';
import { JobsComponent } from './Mycomponents/recruiter/jobs/jobs.component';
import { RecruiterComponent } from './MyComponents/recruiter/recruiter.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';

const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"admin", 
children:[
{path:"", component:AdminComponent},
{path:"adminfreelancer", component:AdminfreelancerComponent},
{path:"adminrecruiter", component:AdminrecruiterComponent},
{path:"adminskill", component:SkillComponent}

]


},
  {path:"freelancer", 
  children:[
    {path:"", component:FreelancerComponent},
    {path:"freelancerbookmark", component:BookmarkComponent},
    {path:"freelancerskillex", component:SkillexpComponent}
    
    
    ]
},
  {path:"recruiter", 
  children:[
    {path:"", component:RecruiterComponent},
    {path:"recruiterbookmarkfreelancer", component:BookmarkfreelancerComponent},
    {path:"recruiterjobs", component:JobsComponent}
    
    
    ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
