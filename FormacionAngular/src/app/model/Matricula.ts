import { Alumno } from "./Alumno";
import { Curso } from "./Curso";
export class Matricula{
    alumnoDto: Alumno = new Alumno;
    cursoDto: Curso = new Curso;
    nota!: number;
}