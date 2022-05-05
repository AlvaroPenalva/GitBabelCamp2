import { Component, OnInit } from '@angular/core';
import { BuscarService } from '../services/buscar.service';
import { Router } from '@angular/router';
import { Matricula } from '../model/Matricula';
@Component({
  selector: 'app-matriculas-fechas',
  templateUrl: './matriculas-fechas.component.html',
  styleUrls: ['./matriculas-fechas.component.css']
})
export class MatriculasFechasComponent implements OnInit {

  constructor(private service: BuscarService, private router: Router) { }

  fechaIni:string = "";
  fechaFin:string = "";

  matriculas: Matricula[] = [];

  ngOnInit(): void {
  }

  buscarMatriculas(){
    this.service.buscarMatriculas(this.fechaIni, this.fechaFin).subscribe(data => this.matriculas = data);
    
  }

}
