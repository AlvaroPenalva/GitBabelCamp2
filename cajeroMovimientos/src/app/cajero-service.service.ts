import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MovimientoDto } from './model/Movimiento';
@Injectable({
  providedIn: 'root'
})
export class CajeroServiceService {

  //urlConsultarMovimientosFechas:string = "http://localhost:8080/16_ejercicio_cajero/MovimientosPorFechas"
  urlConsultarMovimientosFechas:string = "MovimientosPorFechas";
  //urlConsultarSaldo:string = "http://localhost:8080/16_ejercicio_cajero/GetSaldoCuenta"
  urlConsultarSaldo:string = "GetSaldoCuenta"

  constructor(private http:HttpClient) { }
  

  getMovimientos(fechaIni: string, fechaFin: string){
    return this.http.get<MovimientoDto[]>(this.urlConsultarMovimientosFechas, {
      params: { fechaIni: fechaIni, fechaFin: fechaFin },
    });
  }

  getSaldo(){
    return this.http.get<number>(this.urlConsultarSaldo);
  }
}
