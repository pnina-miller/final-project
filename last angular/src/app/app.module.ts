import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LearnComponent } from './learn/learn.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { DetailsComponent } from './details/details.component';
import { RouterModule,Routes } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { EasyService } from './Easy.service';
import { HttpClientModule } from '@angular/common/http';
import { MorefuncsComponent } from './morefuncs/morefuncs.component';
import { HomePageComponent } from './home-page/home-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LearnComponent,
    PageNotFoundComponentComponent,
    DetailsComponent,
    SignInComponent,
    MorefuncsComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [EasyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
