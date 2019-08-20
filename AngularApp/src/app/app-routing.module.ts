import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestPageComponent } from './pages/test-page/test-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
<<<<<<< HEAD
=======
import { RegisterPageComponent } from './pages/register-page/register-page.component';
>>>>>>> 8a01c0068fad5d60e0dfcbb4addbf56796df9107


const routes: Routes = [
  { path: 'users', component: TestPageComponent},
<<<<<<< HEAD
  { path: 'login', component: LoginPageComponent}
=======
  { path: 'login', component: LoginPageComponent},
  { path: 'register', component: RegisterPageComponent}
>>>>>>> 8a01c0068fad5d60e0dfcbb4addbf56796df9107
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
