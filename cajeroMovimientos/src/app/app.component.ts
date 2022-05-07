import {
  Component
} from '@angular/core';
import {
  CajeroServiceService
} from './cajero-service.service';
import {
  MovimientoDto
} from './model/Movimiento';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cajeroMovimientos';

  fechaIni: string = "";
  fechaFin: string = "";
  movimientos: MovimientoDto[] = [];
  saldo: number = 0;

  constructor(private service: CajeroServiceService) {

    service.getSaldo().subscribe(data => this.saldo = data);

  }

  buscarMovimientos() {
    this.service.getMovimientos(this.fechaIni, this.fechaFin).subscribe(data => this.movimientos = data);
  }

}
