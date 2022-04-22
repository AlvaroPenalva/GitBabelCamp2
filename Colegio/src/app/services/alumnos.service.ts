import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Alumno } from '../model/Alumno';
@Injectable({
  providedIn: 'root'
})
export class AlumnosService {

  //urlAlumnos:string="http://localhost:8080/07_alumnos_yo/Buscador";
  urlAlumnos:string="Buscador";
  //urlCursos:string ="http://localhost:8080/07_alumnos_yo/Cursos";
  urlCursos:string = "Cursos";
  constructor(private http:HttpClient) { }

  buscarAlumnos(curso:string){
    return this.http.get<Alumno[]>(this.urlAlumnos,{params:{curso:curso}});
  }

  buscarCursos(){
    return this.http.get<string[]>(this.urlCursos);
  }

}
