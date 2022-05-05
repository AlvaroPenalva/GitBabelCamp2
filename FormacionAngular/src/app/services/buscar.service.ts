import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { HttpClient } from '@angular/common/http';
import { Matricula } from '../model/Matricula';
@Injectable({
  providedIn: 'root'
})
export class BuscarService {

  //urlAlumnosPorCurso:string="http://localhost:8080/15_formacion_triple_entidad/BuscarAlumnos";
  urlAlumnosPorCurso:string="BuscarAlumnos";
  //urlCursosPorAlumno:string ="http://localhost:8080/15_formacion_triple_entidad/BuscarCursos";
  urlCursosPorAlumno:string = "BuscarCursos";
  //urlCursos:string ="http://localhost:8080/15_formacion_triple_entidad/Cursos";
  urlCursos:string = "Cursos";
  //urlAlumnos:string="http://localhost:8080/15_formacion_triple_entidad/Alumnos";
  urlAlumnos:string = "Alumnos";
  //urlMatricularAlumno:string = "http://localhost:8080/15_formacion_triple_entidad/Matricular"
  urlMatricularAlumno:string = "Matricular"
  //urlCursosNoMatriculado:string = "http://localhost:8080/15_formacion_triple_entidad/NoMatriculados"
  urlCursosNoMatriculado:string = "NoMatriculados"
  //urlConsultarMatriculasFechas:string = "http://localhost:8080/15_formacion_triple_entidad/MatriculasPorFecha"
  urlConsultarMatriculasFechas:string = "MatriculasPorFecha";

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
