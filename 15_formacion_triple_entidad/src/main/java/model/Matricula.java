package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="matriculas")
public class Matricula {

	@EmbeddedId
	private MatriculaPK pk;
	double nota;
	
	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso", insertable = false, updatable = false)
	Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
	Alumno alumno;
	
	public Matricula(int nota) {
		super();
		this.nota = nota;
	}
    public Matricula( Curso curso, Alumno alumno,double nota) {
		super();
		this.nota = nota;
		this.curso = curso;
		this.alumno = alumno;
	}
}
