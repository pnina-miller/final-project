import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User.model';
import { EasyService } from '../Easy.service';
import $ from 'jquery'

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {



  detailsForm: FormGroup;
  constructor(private _UsersListService: EasyService, private _acr: ActivatedRoute, private _router: Router) {

    console.log("DetailsComponent constructor")
        sessionStorage.length>0?this.isNew=false:this.user=new User();
        console.log("is new: ",this.isNew)
    this.user = JSON.parse(sessionStorage.getItem("user"))||new User()

//this.user?this.isNew==false:this.user=new User();
    this.show = false;
  }

  //Vriables
  user: User;
  isNew: boolean = true;
  isShown: boolean = false;
  //isShownLogin: boolean = true;
  show: boolean;
 month= ["January","February","March","April","May","June","July","August","September","October","November","December"];
getmonthsShort(){

}

  //Functions
  ngOnInit() {
   
    console.log("ngOnInit function")
    this.detailsForm = new FormGroup({
      Email1: new FormControl(),
      password2: new FormControl(),
      IdentityNum3: new FormControl(),
      FirstName4: new FormControl(),
      LastName5: new FormControl(),
      BirthDate6: new FormControl(),
      Gender7: new FormControl(),
      Street8: new FormControl(),
      HouseNum9: new FormControl(),
      Enterance10: new FormControl(),
      Neighborhood11: new FormControl(),
      PostalCode12: new FormControl(),
      City13: new FormControl(),
      Country14: new FormControl(),
      AptNum15: new FormControl(),
      Status16: new FormControl(),
      CreditNum17: new FormControl(),
      Csv18: new FormControl(),
      Valid19: new FormControl(),
      AptArea20: new FormControl(),
      RebuildNeighborhood21: new FormControl()
    })
this.showDetailes()
  }

showDetailes(){
  
  console.log(this.user)

    this.detailsForm.patchValue({
      Emai1l: this.user.email,
      password2: this.user.password,
      IdentityNum3: this.user.identityNum,
      FirstName4: this.user.firstName,
      LastName5: this.user.lastName,
      BirthDate6: this.user.birthDate,
      Gender7: this.user.gender,
      Street8: this.user.street,
      HouseNum9: this.user.houseNum,
      Enterance10: this.user.enterance,
      Neighborhood11: this.user.neighborhood,
      PostalCode12: this.user.postalCode,
      City13: this.user.city,
      Country14: this.user.country,
      AptNum15: this.user.aptNum,
      // Status16: this.user.status,
      CreditNum17: this.user.creditNum,
      Csv18: this.user.csv,
      Valid19: this.user.valid,
      AptArea20: this.user.aptArea,
      RebuildNeighborhood21: this.user.rebuildNeighborhood
    });
   
}
//  ['Email1' , 'password2' ,  'IdentityNum3'  ,'FirstName4' , 'LastName5' ,  'BirthDate6' , 'Street8' ,  'HouseNum9' , 
//  'Enterance10' , 'Neighborhood11' , 'PostalCode12' ,  'City13' , 'Country14' , 'AptNum15' ,  'AptArea20' ,  'RebuildNeighborhood21' ,
//   'CreditNum17' , 'Csv18' , 'Valid19']
  saveDetails() {
    //save details
    console.log("saveDetails function")
    sessionStorage.clear();

    this.user.email= this.detailsForm.controls.Email1.value;
    this.user.password=this.detailsForm.controls.password2.value;
    this.user.identityNum= this.detailsForm.controls.IdentityNum3.value
    this.user.firstName= this.detailsForm.controls.FirstName4.value
    this.user.lastName= this.detailsForm.controls.LastName5.value
    this.user.birthDate= this.detailsForm.controls.BirthDate6.value
    this.user.gender= this.detailsForm.controls.Gender7.value
    this.user.street= this.detailsForm.controls.Street8.value
    this.user. houseNum= this.detailsForm.controls.HouseNum9.value
    this.user.enterance= this.detailsForm.controls.Enterance10.value
    this.user.neighborhood= this.detailsForm.controls.Neighborhood11.value
    this.user.postalCode= this.detailsForm.controls.PostalCode12.value
    this.user.city= this.detailsForm.controls.City13.value
    this.user.country= this.detailsForm.controls.Country14.value
    this.user.aptNum= this.detailsForm.controls.AptNum15.value
    // this.user.status= this.detailsForm.controls.Status16.value
    this.user.creditNum= this.detailsForm.controls.CreditNum17.value
    this.user.csv= this.detailsForm.controls.Csv18.value
    this.user.valid= this.detailsForm.controls.Valid19.value
    this.user.aptArea= this.detailsForm.controls.AptArea20.value
    this.user.rebuildNeighborhood= this.detailsForm.controls.RebuildNeighborhood21.value

    this._UsersListService.postUser(this.user).subscribe(data => {
      console.log(data)
      alert("succeed")
    }, err => {
      console.log("no data!")
    });

  }
}



