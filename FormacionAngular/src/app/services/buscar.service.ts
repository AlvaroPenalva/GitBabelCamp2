import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class BuscarService {

  //urlAlumnosPorCurso:string="http://localhost:8080/11_formacion_persistencia/BuscarAlumnos";
  urlAlumnosPorCurso:string="BuscarAlumnos";
  //urlCursosPorAlumno:string ="http://localhost:8080/11_formacion_persistencia/BuscarCursos";
  urlCursosPorAlumno:string = "BuscarCursos";
  //urlCursos:string ="http://localhost:8080/11_formacion_persistencia/Cursos";
  urlCursos:string = "Cursos";
  //urlAlumnos:string="http://localhost:8080/11_formacion_persistencia/Alumnos";
  urlAlumnos:string = "Alumnos";

  constructor(private http:HttpClient) { }
  

  buscarCursos(){
    return this.http.get<Curso[]>(this.urlCursos);
  }

  buscarAlumnos(){
    return this.http.get<Alumno[]>(this.urlAlumnos);
  }

  buscarAlumnosCurso(curso:string){
    return this.http.get<Alumno[]>(this.urlAlumnosPorCurso,{params:{nombre:curso}});
  }

  buscarCursosAlumno(alumno:string){
    return this.http.get<Curso[]>(this.urlCursosPorAlumno,{params:{usuario:alumno}});
  }
}
