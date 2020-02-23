import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-errormsg',
  templateUrl: './errormsg.component.html',
  styleUrls: ['./errormsg.component.css']
})
export class ErrormsgComponent implements OnInit {

  errormsg = 'Something went Wrong'

  constructor() { }

  ngOnInit() {
  }

}
