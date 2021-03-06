import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaAlumnosComponent } from './lista-alumnos/lista-alumnos.component';
import { ListaCursosComponent } from './lista-cursos/lista-cursos.component';
import { FormsModule } from '@angular/forms';
import { MenuComponent } from './menu/menu.component';
import { HttpClientModule } from '@angular/common/http';
import { MatricularComponent } from './matricular/matricular.component';
import { ConsultarMatriculasComponent } from './consultar-matriculas/consultar-matriculas.component';
import { MatriculasFechasComponent } from './matriculas-fechas/matriculas-fechas.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaAlumnosComponent,
    ListaCursosComponent,
    MenuComponent,
    MatricularComponent,
    ConsultarMatriculasComponent,
    MatriculasFechasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
