import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from 'src/app/api/shared.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  jobId: any;


 
  constructor(private route: ActivatedRoute , private api:SharedService, private router: Router) { }

  ngOnInit(): void {

  }
  m=localStorage.getItem('adminid')

  

}
