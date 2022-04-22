
export class Producto {
  private _id: number;
  private _nombre: string;
  private _seccion: string;
  private _precio: number;
  private _stock: number;

  constructor(id: number, nombre: string, seccion: string, precio: number, stock:number) {
    this._id = id;
    this._nombre = nombre;
    this._seccion = seccion;
    this._precio = precio;
    this._stock = stock;
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

  public get seccion(): string {
    return this._seccion;
  }
  public set seccion(value: string) {
    this._seccion = value;
  }

  public get precio(): number {
    return this._precio;
  }
  public set precio(value: number) {
    this._precio = value;
  }

  public get stock(): number {
    return this._stock;
  }
  public set stock(value: number) {
    this._stock = value;
  }
}
