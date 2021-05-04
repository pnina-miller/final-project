import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User.model';
import { EasyService } from '../Easy.service';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private _UsersListService: EasyService, private _acr: ActivatedRoute, private _router: Router) {

  }

  //variables
  show_password: Boolean = false;
  detailsForm: FormGroup;
  user: User

  //Functions
  showPassword() {
    this.show_password = !this.show_password;
  }
   signIn() {
    console.log("before")
    this._UsersListService.getUserFromServer(this.detailsForm.controls.email.value, this.detailsForm.controls.password.value).subscribe(data => {
      sessionStorage.setItem("user", JSON.stringify(data.data[0]));
      sessionStorage.setItem("isNew", JSON.stringify(false));
      this.user = data.data[0];
      console.log("yes data!");
      debugger
      window.location.href = window.location.origin + "/details";
    }, err => {
      alert("login failed")
      console.log("no data!");

    });
    //send name, password
    //get user
    //open details component
    console.log("after")
    console.log(this.user)


  }
  ngOnInit() {
    this.detailsForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    })
  }

}
