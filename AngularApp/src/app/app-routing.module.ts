import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestPageComponent } from './pages/test-page/test-page.component';


const routes: Routes = [
  { path: 'users', component: TestPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
