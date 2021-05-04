import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LearnComponent } from './learn/learn.component';
import { AppComponent } from './app.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { DetailsComponent } from './details/details.component';
import { MorefuncsComponent } from './morefuncs/morefuncs.component';
import { HomePageComponent } from './home-page/home-page.component';
import { SignInComponent } from './sign-in/sign-in.component';


const routes: Routes = [
  { path:"signIn",component:SignInComponent},
  { path:"details",component:DetailsComponent},
 { path:"learn",component:LearnComponent},
 { path:"more",component:MorefuncsComponent},
 { path:"",component:HomePageComponent},
 {path:"**",component:PageNotFoundComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
