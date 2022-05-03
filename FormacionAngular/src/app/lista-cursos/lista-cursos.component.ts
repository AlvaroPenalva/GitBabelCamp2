import { Component, OnInit } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { BuscarService } from '../services/buscar.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-lista-cursos',
  templateUrl: './lista-cursos.component.html',
  styleUrls: ['./lista-cursos.component.css']
})
export class ListaCursosComponent{

  alumnos: Alumno[] = [];
  cursos: Curso[] = [];
  alumnoActual: string = "";
  constructor(private service: BuscarService, private router: Router) {
    this.service.buscarAlumnos().subscribe(data => this.alumnos = data);
  }
  busqueda() {
    this.service.buscarCursosAlumno(this.alumnoActual).subscribe(data => this.cursos = data);
  }
  navegarMenu(){
    this.router.navigate(['/menu'])
  }
}
