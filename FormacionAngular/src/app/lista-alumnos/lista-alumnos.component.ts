import { Component, OnInit } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { BuscarService } from '../services/buscar.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-lista-alumnos',
  templateUrl: './lista-alumnos.component.html',
  styleUrls: ['./lista-alumnos.component.css']
})
export class ListaAlumnosComponent{

  alumnos: Alumno[] = [];
  cursos: Curso[] = [];
  cursoActual: string = "";
  constructor(private service: BuscarService, private router: Router) {
    this.service.buscarCursos().subscribe(data => this.cursos = data);
  }
  busqueda() {
    this.service.buscarAlumnosCurso(this.cursoActual).subscribe(data =>
      {this.alumnos = data;
      console.log(data);} );
  }

  navegarMenu(){
    this.router.navigate(['/Login'])
  }

}
