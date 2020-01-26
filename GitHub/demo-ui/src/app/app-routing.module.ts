import { NgModule, ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';


export  const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' }, // Forward any request with no path to "/home"
  {
    /**
     * "http://<host>:<port>/home" will show HomeComponent (dir: ./home/)
     */
     path: 'home',
     component: HomeComponent
   }
 ];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
