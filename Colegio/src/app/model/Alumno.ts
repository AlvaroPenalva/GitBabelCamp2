
export class Alumno{
    private _id: number;
  private _nombre: string;
  private _curso: string;
  private _nota: number;

  constructor(id: number, nombre: string, curso: string, nota: number) {
    this._id = id;
    this._nombre = nombre;
    this._curso = curso;
    this._nota = nota;
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

  public get curso(): string {
    return this._curso;
  }
  public set curso(value: string) {
    this._curso = value;
  }

  public get nota(): number {
    return this._nota;
  }
  public set nota(value: number) {
    this._nota = value;
  }
}