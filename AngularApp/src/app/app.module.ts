import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestPageComponent } from './pages/test-page/test-page.component';
import { UserService } from './services/user-service.service';
import { LoginPageComponent } from './pages/login-page/login-page.component'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
<<<<<<< HEAD
=======
import { RegisterPageComponent } from './pages/register-page/register-page.component';
>>>>>>> 8a01c0068fad5d60e0dfcbb4addbf56796df9107




@NgModule({
  declarations: [
    AppComponent,
    TestPageComponent,
<<<<<<< HEAD
    LoginPageComponent
=======
    LoginPageComponent,
    RegisterPageComponent
>>>>>>> 8a01c0068fad5d60e0dfcbb4addbf56796df9107
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
