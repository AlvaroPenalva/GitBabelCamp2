import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaAlumnosComponent } from './lista-alumnos/lista-alumnos.component';
import { ListaCursosComponent } from './lista-cursos/lista-cursos.component';
import { MenuComponent } from './menu/menu.component';
import { MatricularComponent } from './matricular/matricular.component';
import { MatriculasFechasComponent } from './matriculas-fechas/matriculas-fechas.component';
const routes: Routes = [
  {path: 'Login', component: MenuComponent},
  {path: 'alumno', component: ListaAlumnosComponent},
  {path: 'curso', component: ListaCursosComponent},
  {path: 'matricular', component: MatricularComponent},
  {path: 'matriculasFechas', component: MatriculasFechasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
