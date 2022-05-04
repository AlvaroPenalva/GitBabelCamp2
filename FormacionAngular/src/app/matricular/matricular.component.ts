import { Component, OnInit } from '@angular/core';
import { BuscarService } from '../services/buscar.service';
import { Router } from '@angular/router';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
@Component({
  selector: 'app-matricular',
  templateUrl: './matricular.component.html',
  styleUrls: ['./matricular.component.css']
})
export class MatricularComponent{

  alumnos: Alumno[] = [];
  cursos: Curso[] = [];
  alumnoActual: string = "";
  cursoActual: number = 0;
  constructor(private service: BuscarService, private router: Router) { 
    this.service.buscarAlumnos().subscribe(data => this.alumnos = data);
  }

  busqueda(){
    this.service.buscarCursosNoMatriculado(this.alumnoActual).subscribe(data =>{
      this.cursos = data;
      console.log(data);
    });
  }

  matricular(){
    this.service.matricularAlumno(this.cursoActual, this.alumnoActual).subscribe(data => console.log(data));
  }
}
