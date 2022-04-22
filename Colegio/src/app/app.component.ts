import { Component } from '@angular/core';
import {
  AlumnosService} from './services/alumnos.service';
  import { Alumno } from './model/Alumno';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  alumnos: Alumno[] = [];
  cursos: string[] = [];
  cursoActual: string = "";
  constructor(private service: AlumnosService) {
    this.service.buscarCursos().subscribe(data => this.cursos = data);
  }
  busqueda() {
    
    this.service.buscarAlumnos(this.cursoActual).subscribe(data => this.alumnos = data);
  }
}
