import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { HttpClient } from '@angular/common/http';
import { Matricula } from '../model/Matricula';
@Injectable({
  providedIn: 'root'
})
export class BuscarService {

  urlAlumnosPorCurso:string="http://localhost:8080/13_formacion_completo/BuscarAlumnos";
  //urlAlumnosPorCurso:string="BuscarAlumnos";
  urlCursosPorAlumno:string ="http://localhost:8080/13_formacion_completo/BuscarCursos";
  //urlCursosPorAlumno:string = "BuscarCursos";
  urlCursos:string ="http://localhost:8080/13_formacion_completo/Cursos";
  //urlCursos:string = "Cursos";
  urlAlumnos:string="http://localhost:8080/13_formacion_completo/Alumnos";
  //urlAlumnos:string = "Alumnos";
  urlMatricularAlumno:string = "http://localhost:8080/13_formacion_completo/Matricular"
  //urlMatricularAlumno:string = "Matricular"
  urlCursosNoMatriculado:string = "http://localhost:8080/13_formacion_completo/NoMatriculados"
  //urlCursosNoMatriculado:string = "NoMatriculados"
  urlConsultarMatriculasFechas:string = "http://localhost:8080/13_formacion_completo/MatriculasPorFecha"
  //urlConsultarMatriculasFechas:string = "MatriculasPorFecha";

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

  matricularAlumno(idCurso: number, usuario: string) {
    return this.http.post(`${this.urlMatricularAlumno}?idCurso=${idCurso}&usuario=${usuario}`,null)  
  }

  buscarCursosNoMatriculado(alumno:string){
    return this.http.get<Curso[]>(this.urlCursosNoMatriculado,{params:{usuario:alumno}});
  }

  buscarMatriculas(fechaIni: string, fechaFin: string) {
    return this.http.get<Matricula[]>(this.urlConsultarMatriculasFechas, {
      params: { fechaIni: fechaIni, fechaFin: fechaFin },
    });
  }

}
