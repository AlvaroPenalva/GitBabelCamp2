export class Curso {
  private _id: number;
  private _nombre: string;
  private _duracion: number;
  private _precio: number;
  private _fechaInicio: Date;

  constructor(id: number, nombre: string, duracion: number, precio: number, fechaInicio: Date) {
    this._id = id;
    this._nombre = nombre;
    this._duracion = duracion;
    this._precio = precio;
    this._fechaInicio = fechaInicio;
  }


  public get id(): number {
    return this._id;
  }
  public set id(value: number) {
    this._id = value;
  }

  public get nombre(): string {
    return this._nombre;
  }
  public set nombre(value: string) {
    this._nombre = value;
  }

  public get duracion(): number {
    return this._duracion;
  }
  public set duracion(value: number) {
    this._duracion = value;
  }

  public get precio(): number {
    return this._precio;
  }
  public set precio(value: number) {
    this._precio = value;
  }

  public get fechaInicio(): Date {
    return this._fechaInicio;
  }
  public set fechaInicio(value: Date) {
    this._fechaInicio = value;
  }
}
