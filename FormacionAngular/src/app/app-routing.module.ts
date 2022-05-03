import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaAlumnosComponent } from './lista-alumnos/lista-alumnos.component';
import { ListaCursosComponent } from './lista-cursos/lista-cursos.component';
import { MenuComponent } from './menu/menu.component';
const routes: Routes = [
  {path: 'menu', component: MenuComponent},
  {path: 'alumno', component: ListaAlumnosComponent},
  {path: 'curso', component: ListaCursosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
