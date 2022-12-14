import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';
import { AdminComponent } from './Mycomponents/admin/admin.component';
import { FreelancerComponent } from './Mycomponents/freelancer/freelancer.component';
import { RecruiterComponent } from './MyComponents/recruiter/recruiter.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SkillComponent } from './Mycomponents/admin/skill/skill.component';
import { AdminfreelancerComponent } from './Mycomponents/admin/adminfreelancer/adminfreelancer.component';
import { AdminrecruiterComponent } from './Mycomponents/admin/adminrecruiter/adminrecruiter.component';
import { BookmarkComponent } from './Mycomponents/freelancer/bookmark/bookmark.component';
import { SkillexpComponent } from './Mycomponents/freelancer/skillexp/skillexp.component';
import { BookmarkfreelancerComponent } from './Mycomponents/recruiter/bookmarkfreelancer/bookmarkfreelancer.component';
import { JobsComponent } from './Mycomponents/recruiter/jobs/jobs.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminComponent,
    FreelancerComponent,
    RecruiterComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    SkillComponent,
    AdminfreelancerComponent,
    AdminrecruiterComponent,
    BookmarkComponent,
    SkillexpComponent,
    BookmarkfreelancerComponent,
    JobsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
