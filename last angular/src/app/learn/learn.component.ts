import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-learn',
  templateUrl: './learn.component.html',
  styleUrls: ['./learn.component.css']
})
export class LearnComponent implements OnInit {

  constructor() { }
  isShown1: boolean = false ; // hidden by default
  isShown2: boolean = false ;
  isShown3: boolean = false ;
  isShown4: boolean = false ;

  ngOnInit() {
  }
  open1() {  
    this.isShown1 = ! this.isShown1;
   
  } 
  open2(){
    this.isShown2 = ! this.isShown2;
  }
  open3(){
    this.isShown3 = ! this.isShown3;
  }
  open4(){
    this.isShown4 = ! this.isShown4;
  }
}
