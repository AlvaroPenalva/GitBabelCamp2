import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navegarListaAlumnos(){
    this.router.navigate(['/alumno'])
  }

  navegarListaCursos(){
    this.router.navigate(['/curso'])
  }

  navegarMatricular(){
    this.router.navigate(['matricular'])
  }

  navegarMatriculasFechas(){
    this.router.navigate(['matriculasFechas'])
  }

}
