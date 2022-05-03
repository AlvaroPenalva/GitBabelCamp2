export class Alumno {
  private _usuario: string;

  private _password: string;

  private _nombre: string;

  private _email: string;

  private _edad: number;

  constructor(usuario:string, password:string, nombre:string, email:string, edad:number){
    this._usuario = usuario;
    this._password = password;
    this._nombre = nombre;
    this._email = email;
    this._edad = edad;
  }

  public get usuario(): string {
    return this._usuario;
  }
  public set usuario(value: string) {
    this._usuario = value;
  }

  public get password(): string {
    return this._password;
  }
  public set password(value: string) {
    this._password = value;
  }

  public get nombre(): string {
    return this._nombre;
  }
  public set nombre(value: string) {
    this._nombre = value;
  }

  public get email(): string {
    return this._email;
  }
  public set email(value: string) {
    this._email = value;
  }

  public get edad(): number {
    return this._edad;
  }
  public set edad(value: number) {
    this._edad = value;
  }
}
